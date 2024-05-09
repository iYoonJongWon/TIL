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
        Spacer(modifier = Modifier.size(20.dp)) // 20dp의 수직 공간 추가
        Divider(modifier = Modifier)
    }
}
