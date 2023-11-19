package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.tests

import es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src.SmartLightDevice
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.testng.Assert.assertNotEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SmartLightDeviceTests {

    @Test
    fun increaseBrightnessShouldIncreaseBrightnessLevel() {
        val light = SmartLightDevice("Test Light", "Utility")
        val initialBrightness = light.brightnessLevel
        light.increaseBrightness()
        assertTrue(light.brightnessLevel > initialBrightness)
    }

    @Test
    fun decreaseBrightnessShouldDecreaseBrightnessLevel() {
        val light = SmartLightDevice("Test Light", "Utility")
        light.increaseBrightness() // Asegurar que el brillo no está en el mínimo
        val initialBrightness = light.brightnessLevel
        light.decreaseBrightness()
        assertTrue(light.brightnessLevel < initialBrightness)
    }

    @Test
    fun brightnessLevelShouldNotExceedMaximumLimit() {
        val light = SmartLightDevice("Test Light", "Utility")
        repeat(150) { light.increaseBrightness() } // Aumentar más allá del límite esperado
        assertTrue(light.brightnessLevel <= 100) // Asumiendo que 100 es el máximo
    }

    @Test
    fun brightnessLevelShouldNotGoBelowMinimumLimit() {
        val light = SmartLightDevice("Test Light", "Utility")
        repeat(150) { light.decreaseBrightness() } // Disminuir más allá del límite esperado
        assertTrue(light.brightnessLevel >= 0) // Asumiendo que 0 es el mínimo
    }

    @Test
    fun turnOnShouldSetDeviceStatusToOn() {
        val light = SmartLightDevice("Test Light", "Utility")
        light.turnOn()
        assertEquals("on", light.deviceStatus)
    }

    @Test
    fun turnOffShouldSetDeviceStatusToOff() {
        val light = SmartLightDevice("Test Light", "Utility")
        light.turnOff()
        assertEquals("off", light.deviceStatus)
    }

    @Test
    fun turnOnShouldSetBrightnessToInitialValue() {
        val light = SmartLightDevice("Test Light", "Utility")
        light.turnOn()
        assertNotEquals(0, light.brightnessLevel)
    }

    @Test
    fun turnOffShouldSetBrightnessToZero() {
        val light = SmartLightDevice("Test Light", "Utility")
        light.turnOff()
        assertEquals(0, light.brightnessLevel)
    }

}