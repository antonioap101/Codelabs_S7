package es.ulpgc.conceptosBasicosKotlin.tiposDeFuncionesYLambdas

fun oldMain() {
    // :: operador de referencia a función
    val trickFunction1 = ::trick1

    // Almacena función definida como lambda
    val trickFunction = trick

    // Llamadas a las funciones
    trick()
    trickFunction()
    trickFunction1()
    treat()
}

fun main() {
    // Funciones lambda para pasar como parámetro
    val coins: (Int) -> String = { quantity -> "$quantity quarters"}
    val coinsImplicit: (Int) -> String = {"$it quarters"}
    val cupcake: (Int) -> String = {"Have a cupcake!"}


    // Expresión lambda clásica
    val treatFunction = trickOrTreat(isTrick = false, coins)

    // Expresión lambda con uso implicito de parámetros ($it)
    val treatFunction2 = trickOrTreat(isTrick = false, coinsImplicit)

    // Pasar expresion lambda directamente a función
    val treatFunction3 = trickOrTreat(isTrick = false, {"$it quarters"})

    // Sintaxis de expresion lambda final (fuera de los paréntesis)
    val treatFunction4 = trickOrTreat(isTrick = false) { "$it quarters" }

    // Pasar valor null en lugar de función lambda
    val trickFunction = trickOrTreat(isTrick = true, null)

    /*
    * Las variables treatFunction, treatFunction2, treatFunction3, y treatFunction4 en
    * el código no almacenan el resultado de la llamada a la función porque están siendo
    * inicializadas con el resultado de trickOrTreat, que retorna una función
    * de tipo () -> Unit. Es decir, lo que estas variables están almacenando es una
    * referencia a una función que aún no ha sido invocada.
    */
    // Llamadas a las funciones a través de las variables
    treatFunction()
    treatFunction2()
    treatFunction3()
    treatFunction4()

    println("Función de orden superior <repeat>")
    repeat(4){ i->
        print("Ejecución $i: ")
        trickFunction()
    }

}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) trick
    else {
        if (extraTreat != null) { println(extraTreat(5)) }
        treat
    }
}

fun trick1(){
    println("No treats!")
}

val trick: () -> Unit = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}