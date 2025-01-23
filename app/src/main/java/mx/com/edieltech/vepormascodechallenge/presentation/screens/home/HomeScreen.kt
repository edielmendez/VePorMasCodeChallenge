package mx.com.edieltech.vepormascodechallenge.presentation.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import mx.com.edieltech.vepormascodechallenge.domain.models.PhotoModel
import mx.com.edieltech.vepormascodechallenge.presentation.common.composeext.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.HomeShimmerScreen
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.PhotosList
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEffect
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.mvi.HomeEvent
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetailScreen: (String, String)-> Unit
){

    val context = LocalContext.current

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Photos"
            )
        }
    ) { innerPadding ->

        if(state.isLoading){
            HomeShimmerScreen()
        }else{
            HomeScreenContent(
                modifier = Modifier.padding(innerPadding),
                photos = state.photos,
                onItemClick = {
                    navigateToDetailScreen(it.title, it.thumbnailUrl)
                },
                onDeleteIconClick = {
                    viewModel.setEvent(HomeEvent.DeletePhoto(it))
                }
            )
        }
    }


    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest {
            when(it){
                is HomeEffect.ShowToast -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    photos: List<PhotoModel> = emptyList(),
    onItemClick: (PhotoModel) -> Unit,
    onDeleteIconClick: (Int) -> Unit
){
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        PhotosList(
            photos = photos,
            onItemClick = onItemClick,
            onDeleteIconClick = onDeleteIconClick
        )
    }
}

@Composable
@ThemePreviews
fun HomeScreenContentPreview(){
    VePorMasCodeChallengeTheme {
        HomeScreenContent(
            onItemClick = {

            },
            onDeleteIconClick = {

            }
        )
    }
}