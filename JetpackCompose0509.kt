//Practice
@Composable
fun Greeting(name: String) {
    Column {
        for (i in 1..10) {
            MySpacerDemo(i)
            }
        }
    }


}@Composable
fun MySpacerDemo(number2: Int) {
    Column {
        Text("$number2")
        Spacer(modifier = Modifier.size(20.dp))
        Divider(modifier = Modifier)
    }
}

//Assignment
@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "성격유형소개", color = Color.Blue)
        val imageModifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Green)
        Image(
            painter = painterResource(id = R.drawable.mbti),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = imageModifier
        )

        }
    }
