@Composable
fun Greeting(name: String) {
    Column {
        for (i in 1..10) {
                LoginTitle(i)
            }
        }
    }


@Composable
fun LoginTitle(number:Int){
    Row {
        Text("$number", fontSize = 20.sp)
    }
}
