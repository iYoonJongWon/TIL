package com.example.photopicker20522

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.photopicker20522.ui.theme.Photopicker20522Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Photopicker20522Theme {
                Row{
                    Photopicker()
                    Photopicker2()
                }
            }
        }
    }
}

@Composable
fun Mainscreen() {

}

@Composable
fun Photopicker() {
    var imageUri by remember {
        mutableStateOf<List<Uri?>>(emptyList())
    }
    val pickMultipleMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) {uris ->
            imageUri = uris
        }
    Column {
        Button(onClick = {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }) {
            Text(text = "사진 가져오는 버튼")
        }
        val ImageModifier = Modifier
            .size(width = 100.dp, height = 100.dp)
        Column {
            for (i in 1..5)
                Image(painter = rememberAsyncImagePainter(imageUri.getOrNull(i-1)),
                    contentDescription = null,
                    modifier = ImageModifier)
        }
    }
}
@Composable
fun Photopicker2() {
    var imageUri by remember {
        mutableStateOf<List<Uri?>>(emptyList())
    }
    val pickMultipleMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) {uris ->
            imageUri = uris
        }
    Column {
        Button(onClick = {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }) {
            Text(text = "회색으로 사진 가져오는 버튼")
        }
        val ImageModifier = Modifier
            .size(width = 100.dp, height = 100.dp)
        Column{
            for (i in 1..5) {
                Image(painter = rememberAsyncImagePainter(imageUri.getOrNull(i-1)),
                    contentDescription = null,
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }),
                    modifier = ImageModifier)
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Photopicker20522Theme {
        Row {
            Photopicker()
            Photopicker2()
        }

    }
}
