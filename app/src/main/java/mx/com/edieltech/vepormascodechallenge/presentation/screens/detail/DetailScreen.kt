package mx.com.edieltech.vepormascodechallenge.presentation.screens.detail


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import mx.com.edieltech.vepormascodechallenge.presentation.designsystem.DefaultTopAppBar

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    title: String,
    image: String,
    onButtonBackClick: () -> Unit
){

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Detalle de la foto",
                leftIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onLeftIconClick = onButtonBackClick
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GlideImage(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp, vertical = 16.dp),
                    model = "https://i.pravatar.cc/300", contentDescription = title,
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}