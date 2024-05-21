class car(
    val model: String,
    val speed: Int,
    val gas: Int,
) {
    fun printfo() {
        println("name: $model")
        println("gas ${addgas()}")
        println("speed: ${getSpeeds()}")
    }

    var inputgas: Int = 50

    var power: Int = 0
    fun increaseSpeed() {
        power = when {
            power < 10 -> 10
            power < 50 -> 50
            else -> 100
        }
    }

    fun getSpeeds(): Int {
        return (speed + power)
    }

    fun addgas(): Int {
        return gas + inputgas
    }
}

val mycar = car(
    "현대차",
    30,
    50
)
mycar.printfo()
mycar.increaseSpeed()
mycar.printfo()
mycar.increaseSpeed()
mycar.printfo()
mycar.increaseSpeed()
mycar.printfo()
mycar.getSpeeds()
