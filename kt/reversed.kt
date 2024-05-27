##단어의 길이를 확인하고 반대로 뒤집고 리스트 넣는 코드

import java.util.Stack
fun reverseWord(name: String) {
    println(name[0])
    val stack = mutableListOf<Char>()
    val stack1 = mutableListOf<Int>()
        
    for (i:Int in 0..name.count()-1) {
        stack.add(name[name.count()-1-i])
        stack1.add(name.count()-1-i)
    }
    println(stack)
    println(stack1)
}
reverseWord("hello")
reverseWord("bonjour")
