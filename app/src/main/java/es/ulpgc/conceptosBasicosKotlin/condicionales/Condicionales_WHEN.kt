package es.ulpgc.conceptosBasicosKotlin.condicionales

fun trafficLightColors2(trafficLightColor: String){
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}

fun valueClassifier(x: Any) {
    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}

fun main(){
    trafficLightColors2("Red")
    trafficLightColors2("Yellow")
    trafficLightColors2("Amber")
    trafficLightColors2("Green")
    trafficLightColors2("Black")
    println()
    valueClassifier(2)
    valueClassifier(4)
    valueClassifier(40)
    valueClassifier("String Test")
}