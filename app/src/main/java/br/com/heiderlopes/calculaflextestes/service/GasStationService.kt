package br.com.heiderlopes.calculaflextestes.service

import br.com.heiderlopes.calculaflextestes.model.GasStation
import retrofit2.Call
import retrofit2.http.GET

interface GasStationService {

    @GET("/v2/5d3b4f9a3000006162a2a07f")
    fun getGasStations(): Call<List<GasStation>>
}