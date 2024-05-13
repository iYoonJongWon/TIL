// Main Activity

package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti.ui.theme.MbtiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    Row {
                        Buttonintj()
                        Buttonintp()
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Buttonentp()
                        Buttonentj()
                    }
                }
            }
        }
    }
    @Composable
    fun Buttonintj() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, intj::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "intj")
        }
    }
    @Composable
    fun Buttonintp() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, intp::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "intp")

        }
    }
    @Composable
    fun Buttonentj() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, entp::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "entp")

        }
    }
    @Composable
    fun Buttonentp() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, entj::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "entj")

        }
    }
}

//intp

package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class intp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    LastScreen()

                    val imageModifier: Modifier = Modifier
                        .size(450.dp)
                    Image(
                        painter = painterResource(id = R.drawable.intp),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = imageModifier
                    )

                }

            }
        }
    }
    @Composable
    fun LastScreen() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "메인으로")
        }
    }
}

//intj

package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class intj : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    LastScreen()

                    val imageModifier = Modifier
                        .size(450.dp)
                    Image(
                        painter = painterResource(id = R.drawable.intj),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = imageModifier
                    )


                }

            }
        }
    }

    @Composable
    fun LastScreen() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "메인으로")
        }
    }
}

//intp

package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class intp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    LastScreen()

                    val imageModifier: Modifier = Modifier
                        .size(450.dp)
                    Image(
                        painter = painterResource(id = R.drawable.intp),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = imageModifier
                    )

                }

            }
        }
    }
    @Composable
    fun LastScreen() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "메인으로")
        }
    }
}

//entj
package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class entj : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    LastScreen()

                    val imageModifier = Modifier
                        .size(450.dp)
                    Image(
                        painter = painterResource(id = R.drawable.entj),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = imageModifier
                    )


                }

            }
        }
    }

    @Composable
    fun LastScreen() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "메인으로")
        }
    }
}

//entp
package com.example.mbti

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mbti.ui.theme.MbtiTheme

class entp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbtiTheme {
                Column {
                    LastScreen()

                    val imageModifier = Modifier
                        .size(450.dp)
                    Image(
                        painter = painterResource(id = R.drawable.entp),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = imageModifier
                    )


                }

            }
        }
    }
    @Composable
    fun LastScreen() {
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "메인으로")
        }
    }
}

