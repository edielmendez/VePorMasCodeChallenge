package mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.com.edieltech.vepormascodechallenge.presentation.common.composeext.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.common.composeext.shimmerEffect
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@Composable
fun HomeShimmerScreen() {
    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "",
                leftIcon = null,
                rightIcon = null,
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            LazyColumn {
                items(10) {
                    DPHomeShimmerItem()
                }
            }
        }
    }
}

@Composable
fun DPHomeShimmerItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(0.3F)
                .height(40.dp)
                .padding(end = 16.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .size(32.dp)
                .shimmerEffect()
        )
    }

}

@ThemePreviews
@Composable
fun HomeShimmerScreenPrev() {
    VePorMasCodeChallengeTheme {
        Surface {
            HomeShimmerScreen()
        }
    }
}