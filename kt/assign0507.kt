//짝수합
var j = 0

for (i in 1..100 step 2) {
    j = j + i + 1
   }
println(j)


//FizzBuzz 구현
for (i in 1..100){
    if (i % 15 == 0){
        println("PizzBuzz")
    }
        else if (i % 3 == 0){
        println("Pizz")
    }
        else if (i % 5 == 0){
        println("Buzz")
    }
    else println(i)
}

