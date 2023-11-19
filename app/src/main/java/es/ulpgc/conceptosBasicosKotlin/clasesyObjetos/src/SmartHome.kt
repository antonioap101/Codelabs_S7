package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src

// The SmartHome class HAS-A smart TV device and smart light.
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
){

    var deviceTurnOnCount =  0
        private set


    fun turnOnTv(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.previousChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.decreaseBrightness()
    }


    fun turnOnAllDevices() {
        turnOnTv()
        turnOnLight()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }

    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    fun printLightInfo(){
        smartLightDevice.printDeviceInfo()
    }

}