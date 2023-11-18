package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos

// Smart Light Device IS-A smart device.
class SmartLightDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory){
    private var brightnessLevel = 0
        set(value) { field = if (value in 0..100) value else field }

    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")
    }
}