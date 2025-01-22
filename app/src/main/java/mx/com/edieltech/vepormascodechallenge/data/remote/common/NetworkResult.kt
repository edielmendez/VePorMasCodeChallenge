package mx.com.edieltech.vepormascodechallenge.data.remote.common

sealed class NetworkResult<out T>{
    class Success<T>(val data: T): NetworkResult<T>()
    class Error(val error: String): NetworkResult<Nothing>()
}