package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos

open class SmartDevice protected constructor(val name: String , val category: String) {

    var deviceStatus: String = "offline"
        protected set


    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        var deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn(){
        // cuerpo de la función
    }
    open fun turnOff(){
        // cuerpo de la función
    }

}


