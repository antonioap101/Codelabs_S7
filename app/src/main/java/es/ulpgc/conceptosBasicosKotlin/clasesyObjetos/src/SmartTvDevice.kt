package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src

// Smart TV IS-A smart device.
class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart TV"

    var speakerVolume by RangeCalculator(initialValue = 2, minValue = 0, maxValue = 100)
        private set

    var channelNumber by RangeCalculator(initialValue = 1, minValue = 0, maxValue = 200)
        private set

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }

    fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    fun previousChannel(){
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

}