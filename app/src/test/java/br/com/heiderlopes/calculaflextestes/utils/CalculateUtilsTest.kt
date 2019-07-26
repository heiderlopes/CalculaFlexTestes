package br.com.heiderlopes.calculaflextestes.utils

import br.com.heiderlopes.calculaflextestes.model.Fuel
import org.junit.Assert
import org.junit.Test

class CalculateUtilsTest {

    @Test
    fun `should return gasoline fuel`() {
        val fuel = CalculateUtils.getBestFuel(4.0, 5.0,
            3.0, 2.0)

        Assert.assertEquals(Fuel.GASOLINE, fuel)
    }

    @Test
    fun `should return ethanol fuel`() {
        val fuel = CalculateUtils.getBestFuel(4.0, 0.0,
            3.0, 10.0)

        Assert.assertEquals(Fuel.ETHANOL, fuel)
    }

}