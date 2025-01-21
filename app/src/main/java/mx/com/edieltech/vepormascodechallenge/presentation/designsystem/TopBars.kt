package mx.com.edieltech.vepormascodechallenge.presentation.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.com.edieltech.vepormascodechallenge.presentation.common.ThemePreviews
import mx.com.edieltech.vepormascodechallenge.presentation.ui.theme.VePorMasCodeChallengeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    title: String,
    leftIcon: ImageVector? = null,
    rightIcon: ImageVector? = null,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {}

){
    Surface(
        shadowElevation = 8.dp
    ) {
        TopAppBar(
            title = {
                Text(title)
            },
            navigationIcon = {
                leftIcon?.let {
                    IconButton(onClick = onLeftIconClick) {
                        Icon(imageVector = it, contentDescription = "Ir hacia atras")
                    }
                }
                //Icons.Filled.ArrowBack
            },
            actions = {
                rightIcon?.let {
                    IconButton(onClick = onRightIconClick) {
                        Icon(
                            imageVector = it,
                            contentDescription = ""
                        )
                    }
                }
            }
        )
    }
}

@ThemePreviews
@Composable
fun DPDefaultTopBarPrev(){
    VePorMasCodeChallengeTheme {
        Surface {
            DefaultTopAppBar(
                title = "Title",
            )
        }
    }
}