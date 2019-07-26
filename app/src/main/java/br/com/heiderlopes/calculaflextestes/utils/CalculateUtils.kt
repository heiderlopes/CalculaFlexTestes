package br.com.heiderlopes.calculaflextestes.utils

import br.com.heiderlopes.calculaflextestes.model.Fuel

object CalculateUtils {

    fun getBestFuel(ethanolAverage: Double, gasAverage: Double,
            ethanolPrice: Double, gasPrice: Double) : Fuel{

        val performanceOfMyCar = calculateCarPerformance(ethanolAverage, gasAverage)
        val priceOfFuelIndice = ethanolPrice / gasPrice

        return if (priceOfFuelIndice <= performanceOfMyCar) {
            Fuel.ETHANOL
        } else {
            Fuel.GASOLINE
        }
    }

    fun calculateCarPerformance(ethanolAverage: Double, gasAverage: Double)
            = ethanolAverage / gasAverage
}