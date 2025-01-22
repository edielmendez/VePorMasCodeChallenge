package mx.com.edieltech.vepormascodechallenge.presentation.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mx.com.edieltech.vepormascodechallenge.data.remote.common.NetworkResult
import mx.com.edieltech.vepormascodechallenge.domain.usecases.FetchPhotosUseCase
import mx.com.edieltech.vepormascodechallenge.presentation.common.viewmodel.MVIBaseViewModel
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEffect
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchPhotosUseCase: FetchPhotosUseCase
): MVIBaseViewModel<HomeEvent, HomeUiState, HomeEffect>() {

    private var job: Job? = null

    init {
        handleEvent(HomeEvent.FetchPhotos)
    }

    override fun createInitialState() = HomeUiState()

    override fun handleEvent(event: HomeEvent) {
        when (event){
            is HomeEvent.FetchPhotos -> {
                fetchPhotos()
            }

            is HomeEvent.DeletePhoto -> {
                deletePhoto(event.id)
            }
        }
    }

    private fun fetchPhotos(){
        job?.cancel()
        setLoading()
        job = viewModelScope.launch(context = Dispatchers.IO) {
            fetchPhotosUseCase.execute()
                .catch {  }
                .collectLatest { result ->
                    when (result) {
                        is NetworkResult.Success -> {
                            Log.v("PhotosRepositoryImpl", "View model - ${result.data}")
                            setState {
                                copy(
                                    isLoading = false,
                                    photos = result.data
                                )
                            }
                        }

                        is NetworkResult.Error -> {
                            setState {
                                copy(isLoading = false, error = result.error)
                            }
                            setEffect {
                                HomeEffect.ShowToast(state.error)
                            }
                        }
                    }
                }
        }
    }

    private fun deletePhoto(id: Int){
        val photoToDelete = state.photos.find { it.id == id }
        photoToDelete?.let { photo ->
            setState {
                copy(
                    photos = state.photos.toMutableList().apply {
                        remove(photo)
                    }
                )
            }
            setEffect { HomeEffect.ShowToast("${photo.title} Eliminado") }
        }

    }

    private fun setLoading(isLoading: Boolean = true) {
        setState {
            copy(isLoading = isLoading)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}