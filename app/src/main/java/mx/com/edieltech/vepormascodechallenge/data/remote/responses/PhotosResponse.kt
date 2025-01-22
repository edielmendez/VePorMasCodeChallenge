package mx.com.edieltech.vepormascodechallenge.data.remote.responses

import com.google.gson.annotations.SerializedName
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel

data class PhotosResponse(
    @SerializedName("albumId"      ) var albumId      : Int?    = null,
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("title"        ) var title        : String? = null,
    @SerializedName("url"          ) var url          : String? = null,
    @SerializedName("thumbnailUrl" ) var thumbnailUrl : String? = null

)


fun PhotosResponse.toPhotoModel() = PhotoModel(
    albumId = this.albumId ?: 0,
    id = this.id ?: 0,
    title = this.title?.replaceFirstChar { it.uppercase() } ?: "",
    url = this.url ?: "",
    thumbnailUrl = this.thumbnailUrl ?: ""
)