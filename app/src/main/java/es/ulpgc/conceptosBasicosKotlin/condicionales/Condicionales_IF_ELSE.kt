package es.ulpgc.conceptosBasicosKotlin.condicionales

fun trafficLightColors(trafficLightColor: String){

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}
fun main(){
    trafficLightColors("Red")
    trafficLightColors("Yellow")
    trafficLightColors("Green")
    trafficLightColors("Black")
}
