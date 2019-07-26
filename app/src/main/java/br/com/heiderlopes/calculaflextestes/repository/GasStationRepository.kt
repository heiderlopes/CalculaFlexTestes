package br.com.heiderlopes.calculaflextestes.repository

import br.com.heiderlopes.calculaflextestes.model.GasStation

interface GasStationRepository {

    fun getGasStations(
        onComplete:(List<GasStation>?) -> Unit,
        onError:(Throwable) -> Unit
    )
}