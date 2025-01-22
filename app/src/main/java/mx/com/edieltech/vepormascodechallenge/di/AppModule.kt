package mx.com.edieltech.vepormascodechallenge.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import mx.com.edieltech.vepormascodechallenge.data.remote.AppService
import mx.com.edieltech.vepormascodechallenge.data.remote.common.RemoteServiceConstants.BASE_URL
import mx.com.edieltech.vepormascodechallenge.data.remote.repository.PhotosRepositoryImpl
import mx.com.edieltech.vepormascodechallenge.domain.repository.PhotosRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Singleton
    @Provides
    fun provideAppService(retrofit: Retrofit): AppService =  retrofit.create(AppService::class.java)

    @Provides
    @Singleton
    fun providePhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository = photosRepositoryImpl


    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
annotation class DefaultDispatcher