package mx.com.edieltech.vepormascodechallenge.presentation.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar
import mx.com.edieltech.vepormascodechallenge.presentation.screens.home.components.PhotosList

@Composable
fun DetailScreen(
    title: String,
    image: String,
    onButtonBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "",
                leftIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onLeftIconClick = onButtonBackClick
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Text(
                modifier = Modifier.padding(horizontal = 32.dp),
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}