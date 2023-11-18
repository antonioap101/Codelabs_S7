package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos

// Smart TV IS-A smart device.
class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeCalculator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeCalculator(initialValue = 1, minValue = 0, maxValue = 200)

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
        deviceStatus = "online"
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        deviceStatus = "offline"
        println("$name turned off")
    }



}