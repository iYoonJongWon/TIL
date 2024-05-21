class StateActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                clickbutton(name = "저장")
            }
        }
    }

    @Composable
    fun clickbutton(name: String) {
        var count by remember { mutableStateOf(0) }
        Button(onClick = {
            count++
        }) {
            Text(text = name, fontSize = 20.sp)
        }
        for (i in 1..count) {
            if (i > 0) {
                Text(text = "$i:저장되었습니다")
            }
        }
    }
}
