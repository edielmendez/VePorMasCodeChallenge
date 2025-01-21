package mx.com.edieltech.vepormascodechallenge.domain.models

import androidx.compose.ui.graphics.drawscope.Stroke

data class PhotoModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
