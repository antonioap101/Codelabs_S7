package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src

fun main() {
    // Crear instancias de SmartTvDevice y SmartLightDevice
    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    val smartLightDevice = SmartLightDevice("Google Light", "Utility")

    // Pruebas con SmartTvDevice
    println("Smart TV Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn()
    smartTvDevice.increaseSpeakerVolume()
    smartTvDevice.nextChannel()
    smartTvDevice.turnOff()
    println("------------------------------------------------")

    // Pruebas con SmartLightDevice
    println("Smart Light Device name is: ${smartLightDevice.name}")
    smartLightDevice.turnOn()
    smartLightDevice.increaseBrightness()
    smartLightDevice.turnOff()
    println("------------------------------------------------")

    // Crear y probar la clase SmartHome
    val smartHome = SmartHome(smartTvDevice, smartLightDevice)
    smartHome.turnOnAllDevices()
    smartHome.increaseTvVolume()
    smartHome.increaseLightBrightness()
    smartHome.turnOffAllDevices()
    println("------------------------------------------------")
}
