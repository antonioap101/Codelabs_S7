package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src

open class SmartDevice protected constructor(val name: String , val category: String) {

    var deviceStatus: String = "off"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        var deviceStatus = when(statusCode){
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    fun printDeviceInfo(){
        println("Device name: $name; category: $category, type: $deviceType")
    }

    open fun turnOn(){
        // cuerpo de la función
        deviceStatus = "on"
    }
    open fun turnOff(){
        // cuerpo de la función
        deviceStatus = "off"
    }

}


