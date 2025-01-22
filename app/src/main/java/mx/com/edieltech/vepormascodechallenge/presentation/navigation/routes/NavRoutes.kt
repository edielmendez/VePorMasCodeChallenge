package mx.com.edieltech.vepormascodechallenge.presentation.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data class DetailRoute(
    val title: String,
    val image: String
)