package mx.com.edieltech.vepormascodechallenge.data.remote.repository

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mx.com.edieltech.vepormascodechallenge.data.remote.AppService
import mx.com.edieltech.vepormascodechallenge.data.remote.common.NetworkResult
import mx.com.edieltech.vepormascodechallenge.data.remote.responses.toPhotoModel
import mx.com.edieltech.vepormascodechallenge.di.DefaultDispatcher
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.domain.repository.PhotosRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepositoryImpl @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    private val service: AppService,
): PhotosRepository  {
    override fun fetchPhotos(): Flow<NetworkResult<List<PhotoModel>>> = flow {
        try {
            val response = service.fetchPhotos()
            Log.v("PhotosRepositoryImpl", "${response}")
            if(response.isSuccessful){
                Log.v("PhotosRepositoryImpl", "${response.body()}")
                val photos = response.body()?.map { it.toPhotoModel() } ?: emptyList()
                emit(NetworkResult.Success(photos))
            }else{
                emit(NetworkResult.Error(response.errorBody().toString()))
            }
        }catch (exception: Exception){
            Log.v("PhotosRepositoryImpl", "${exception}")
            emit(NetworkResult.Error(error = exception.message ?: ""))
        }
    }
}