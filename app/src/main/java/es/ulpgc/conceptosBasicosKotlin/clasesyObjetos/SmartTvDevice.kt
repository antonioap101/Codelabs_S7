package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos

// Smart TV IS-A smart device.
class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory){
    private var speakerVolume = 2
        set(value) { field = if (value in 1..100) value else field }
    private var channelNumber = 1
        set(value) { field = if (value in 0..200) value else field }

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

}