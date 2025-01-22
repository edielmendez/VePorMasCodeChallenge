package mx.com.edieltech.vepormascodechallenge.data.remote

import mx.com.edieltech.vepormascodechallenge.data.remote.responses.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET("photos")
    suspend fun fetchPhotos(): Response<List<PhotosResponse>>
}