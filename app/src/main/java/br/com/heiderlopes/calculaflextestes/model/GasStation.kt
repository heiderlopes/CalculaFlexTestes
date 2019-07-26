package br.com.heiderlopes.calculaflextestes.model

data class GasStation(
    val name: String,
    val ethanol : Double,
    val gasoline: Double
)

enum class Fuel {
    GASOLINE, ETHANOL
}