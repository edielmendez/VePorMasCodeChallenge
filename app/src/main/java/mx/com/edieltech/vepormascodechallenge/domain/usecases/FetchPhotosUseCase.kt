package mx.com.edieltech.vepormascodechallenge.domain.usecases

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.vepormascodechallenge.data.remote.common.NetworkResult
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.domain.repository.PhotosRepository
import javax.inject.Inject

class FetchPhotosUseCase @Inject constructor(
    private val repository: PhotosRepository
) {
    fun execute(): Flow<NetworkResult<List<PhotoModel>>> = repository.fetchPhotos()
}