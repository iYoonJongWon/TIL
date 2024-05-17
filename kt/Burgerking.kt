package com.example.burgerking0517

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burgerking0517.ui.theme.Burgerking0517Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Burgerking0517Theme {
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Burgerking0517Theme {
        Column {
            Image3("치즈와퍼","7,700원",R.drawable.cheese)
            Image3("갈릭불고기와퍼","7,400원",R.drawable.galriccheese)
            Image3("와퍼","7,100원",R.drawable.wap)
            Image3("불고기와퍼","7,100원",R.drawable.bulwap)
            Image3("핫칠리러버","3,900원",R.drawable.hotchililov)
            Image3("핫칠리러버더블","4,900원",R.drawable.hotchililovdouble)
        }
    }
}
@Composable
fun Image(id: Int) {
    val imageModifier = Modifier
        .size(50.dp)
        .background(Color.White)
        .padding(8.dp)
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = imageModifier
    )
}
@Composable
fun Text1(tName1: String, tSize1: Int, tColor1: Color) {
    Text(text = tName1, fontSize = tSize1.sp, color = tColor1)
}
@Composable
fun Image3(tName2: String, tName3: String, id1: Int) {
    Row {
        Image(id1)
        Column {
            Spacer(modifier = Modifier.size(2.dp))
            Text1(tName1 = tName2, tSize1 = 10, tColor1 = Color.Black)
            Spacer(modifier = Modifier.size(2.dp))
            Text1(tName1 = tName3, tSize1 = 8, tColor1 = Color.Red)
        }
        Spacer(modifier = Modifier.size(30.dp))
    }
}
