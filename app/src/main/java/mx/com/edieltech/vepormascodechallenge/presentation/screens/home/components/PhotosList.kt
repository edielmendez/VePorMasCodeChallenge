package mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import mx.com.edieltech.vepormascodechallenge.R
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.presentation.common.composeext.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@Composable
fun PhotosList(
    photos: List<PhotoModel>,
    onItemClick: (PhotoModel) -> Unit,
    onDeleteIconClick: (Int) -> Unit
){
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 12.dp
        )
    ) {
        items(photos){
            PhotoItem(
                modifier = Modifier.fillMaxWidth(),
                photo = it,
                onItemClick = onItemClick,
                onDeleteIconClick = onDeleteIconClick
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoItem(
    modifier: Modifier = Modifier,
    photo: PhotoModel,
    onItemClick: (PhotoModel) -> Unit,
    onDeleteIconClick: (Int) -> Unit
){
    Card(
        modifier = Modifier.padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        /*colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )*/
    ) {
        Row(
            modifier = modifier
                .clickable {
                    onItemClick(photo)
                }
                .padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(0.3F),
                text = photo.title
            )
            /*GlideImage(
                modifier = Modifier.width(20.dp),
                model = photo.thumbnailUrl, contentDescription = photo.title
            )*/
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Eliminar Foto", // Descripción accesible para el icono
                modifier = Modifier.size(32.dp) // Cambiar el tamaño del ícono si es necesario
            )
        }
    }
}

@Preview
@Composable
fun PhotoItemPreview(){
    VePorMasCodeChallengeTheme {
        Surface {
            PhotoItem(
                photo = PhotoModel(
                    albumId = 1,
                    id = 1,
                    title = "Title of test one",
                    url = "https://via.placeholder.com/600/24f355",
                    thumbnailUrl = "https://via.placeholder.com/600/51aa97"
                ),
                onItemClick = {

                },
                onDeleteIconClick = {

                }
            )
        }
    }
}