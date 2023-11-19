
import es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src.SmartHome
import es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src.SmartLightDevice
import es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src.SmartTvDevice
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SmartHomeTests {

    private lateinit var smartTvDevice: SmartTvDevice
    private lateinit var smartLightDevice: SmartLightDevice
    private lateinit var smartHome: SmartHome

    @Before
    fun setUp() {
        smartTvDevice = SmartTvDevice("TestSmartTV", "Entertainment")
        smartLightDevice = SmartLightDevice("TestLightDevice", "Utility")
        smartHome = SmartHome(smartTvDevice, smartLightDevice)
    }

    @Test
    fun turnOnTvShouldIncreaseDeviceTurnOnCount() {
        smartHome.turnOnTv()
        assertEquals(1, smartHome.deviceTurnOnCount)
    }

    @Test
    fun turnOffTvShouldDecreaseDeviceTurnOnCount() {
        smartHome.turnOnTv() // Precondition: Turn on the TV first
        smartHome.turnOffTv()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }

    @Test
    fun turnOnLightShouldIncreaseDeviceTurnOnCount() {
        smartHome.turnOnLight()
        assertEquals(1, smartHome.deviceTurnOnCount)
    }

    @Test
    fun turnOffLightShouldDecreaseDeviceTurnOnCount() {
        smartHome.turnOnLight() // Precondition: Turn on the light first
        smartHome.turnOffLight()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }

    @Test
    fun turnOnAllDevicesShouldIncreaseDeviceTurnOnCount() {
        smartHome.turnOnAllDevices()
        assertEquals(2, smartHome.deviceTurnOnCount)
    }

    @Test
    fun turnOffAllDevicesShouldDecreaseDeviceTurnOnCount() {
        smartHome.turnOnAllDevices() // Precondition: Turn on all devices first
        smartHome.turnOffAllDevices()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }

}
