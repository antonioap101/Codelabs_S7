package es.ulpgc.conceptosBasicosKotlin.clasesyObjetos.src

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeCalculator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
): ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue){
            fieldData = value
        }
    }

}