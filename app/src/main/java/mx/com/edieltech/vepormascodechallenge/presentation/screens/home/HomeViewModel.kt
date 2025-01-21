package mx.com.edieltech.vepormascodechallenge.presentation.screens.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.com.edieltech.vepormascodechallenge.presentation.common.viewmodel.MVIBaseViewModel
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEffect
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): MVIBaseViewModel<HomeEvent, HomeUiState, HomeEffect>() {

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

            }
        }
    }

    private fun fetchPhotos(){
        viewModelScope.launch {
            delay(2000)
            setState {
                copy(
                    isLoading = false
                )
            }
        }
    }

}