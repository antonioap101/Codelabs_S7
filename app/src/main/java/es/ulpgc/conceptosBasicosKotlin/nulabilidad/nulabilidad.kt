package es.ulpgc.conceptosBasicosKotlin.nulabilidad

fun ejemplo1() {
    var favoriteActor: String? = "Sandra Oh"
    var number: Int? = 10

    println("_____Antes de asignar NULL_____")
    println("Number: $number")
    println("Favorite Actor: $favoriteActor")

    println("_____Después de asignar NULL_____")
    number = null
    favoriteActor = null
    println("Favorite Actor: $favoriteActor")
    println("Number: $number")
}

fun checkNullVariable(variable: Any?){
    /*
    * En este caso la variable <variable> no puede ser null en las ramas del when
    * donde se comprueba su tipo (como Int o Double) es debido a las "smart casts" de Kotlin.
    * Al utilizar is Int o is Double, Kotlin automáticamente "castea" la variable al tipo
    * especificado dentro de esa rama del when, asumiendo que no es null.
    * */
    when(variable){
        is Int -> println("The variable has value $variable")
        is Double -> println("The variable has value $variable")
        is String -> println("The number of characters in your name is ${variable.length}.")
        else -> println("The variable is NULL")
    }
}

fun checkNullVariable2(variable: Any?){
    val result = variable ?: "The variable is NULL"
    println(result)
}

fun checkNullVariable3(){
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = if(favoriteActor != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else {
        println("You didn't input a name.")
    }
}

fun main() {
    ejemplo1()

    // checkNullVariable ejemplos
    checkNullVariable(12)
    checkNullVariable(3.14)
    checkNullVariable("Stephen Hanks")
    checkNullVariable(null)

    // checkNullVariable2 ejemplos
    checkNullVariable2(42)
    checkNullVariable2(null)

    //
    checkNullVariable3()
}
