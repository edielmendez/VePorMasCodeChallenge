package mx.com.edieltech.vepormascodechallenge.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.presentation.common.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.HomeShimmerScreen
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@Composable
fun HomeScreen(){
    //HomeShimmerScreen()
    HomeScreenContent()
}

@Composable
fun HomeScreenContent(
    photos: List<PhotoModel> = emptyList()
){

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Personajes"
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Home Screen")
        }
    }
}

@Composable
@ThemePreviews
fun HomeScreenContentPreview(){
    VePorMasCodeChallengeTheme {
        HomeScreenContent(

        )
    }
}