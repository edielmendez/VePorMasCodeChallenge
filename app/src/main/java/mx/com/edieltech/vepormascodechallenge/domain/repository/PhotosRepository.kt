package mx.com.edieltech.vepormascodechallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import mx.com.edieltech.vepormascodechallenge.data.remote.common.NetworkResult
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel

interface PhotosRepository {
    fun fetchPhotos(): Flow<NetworkResult<List<PhotoModel>>>
}