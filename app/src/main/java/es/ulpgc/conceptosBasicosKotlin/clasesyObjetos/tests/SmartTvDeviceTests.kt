package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.tests

import es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src.SmartTvDevice
import org.junit.Assert.assertEquals
import org.junit.Test

class SmartTvDeviceTests {

    @Test
    fun testIncreaseVolume() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        tv.increaseSpeakerVolume()
        assertEquals(3, tv.speakerVolume)
    }

    @Test
    fun testDecreaseVolume() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        tv.increaseSpeakerVolume() // Aumentar el volumen para poder disminuirlo
        val initialVolume = tv.speakerVolume
        tv.decreaseSpeakerVolume()
        assertEquals(initialVolume - 1, tv.speakerVolume)
    }

    @Test
    fun testNextChannel() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        val initialChannel = tv.channelNumber
        tv.nextChannel()
        assertEquals(initialChannel + 1, tv.channelNumber)
    }

    @Test
    fun testPreviousChannel() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        tv.nextChannel() // Cambiar a un canal superior para poder retroceder
        val initialChannel = tv.channelNumber
        tv.previousChannel()
        assertEquals(initialChannel - 1, tv.channelNumber)
    }

    @Test
    fun testTurnOn() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        tv.turnOn()
        assertEquals("on", tv.deviceStatus)
    }

    @Test
    fun testTurnOff() {
        val tv = SmartTvDevice("Test TV", "Entertainment")
        tv.turnOn() // Encender el TV para poder apagarlo
        tv.turnOff()
        assertEquals("off", tv.deviceStatus)
    }
}
