package mx.com.edieltech.vepormascodechallenge.data.remote.repository


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
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

            if(response.isSuccessful){
                response.body()?.let { body ->
                    val photos = body.map { it.toPhotoModel() }
                    emit(NetworkResult.Success(photos))
                } ?: emit(NetworkResult.Success(emptyList()))
            }else{
                emit(NetworkResult.Error(response.errorBody().toString()))
            }
        }catch (exception: Exception){
            emit(NetworkResult.Error(error = exception.message ?: ""))
        }
    }.flowOn(dispatcher)
    .catch { exception ->
        emit(NetworkResult.Error(exception.localizedMessage ?: "Unknown Error"))
    }
}