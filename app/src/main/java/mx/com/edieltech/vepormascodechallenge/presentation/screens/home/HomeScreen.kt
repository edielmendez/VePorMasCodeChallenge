package mx.com.edieltech.vepormascodechallenge.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.presentation.common.composeext.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.HomeShimmerScreen
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.PhotosList
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    if(state.isLoading){
        HomeShimmerScreen()
    }else{
        HomeScreenContent(
            photos = state.photos
        )
    }

}

@Composable
fun HomeScreenContent(
    photos: List<PhotoModel> = emptyList()
){

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Photos"
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            PhotosList(
                photos = photos,
                onItemClick = {

                },
                onDeleteIconClick = {

                }
            )
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