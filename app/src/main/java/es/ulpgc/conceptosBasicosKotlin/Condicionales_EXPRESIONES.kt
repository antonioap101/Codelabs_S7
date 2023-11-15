package es.ulpgc.conceptosBasicosKotlin

fun trafficLightColors_WithExpressions(trafficLightColor: String) {

    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
}

fun trafficLightColors2_WithExpressions(trafficLightColor: String) {
    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow" || trafficLightColor == "Amber" ) "Proceed with caution"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"
    println(message)
}

fun main(){
    val colors = listOf("Amber", "Red", "Yellow", "Green", "Black")
    println("__________IF ELSE__________")
    for (color in colors) trafficLightColors_WithExpressions(color)
    println("__________WHEN__________")
    for (color in colors) trafficLightColors2_WithExpressions(color)

}