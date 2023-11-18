package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos

// Smart Light Device IS-A smart device.
class SmartLightDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart Light"

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

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}