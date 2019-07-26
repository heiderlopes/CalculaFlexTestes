package br.com.heiderlopes.calculaflextestes.repository

import br.com.heiderlopes.calculaflextestes.model.GasStation
import br.com.heiderlopes.calculaflextestes.service.GasStationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GasStationRepositoryImpl(
    val gasStationService: GasStationService
): GasStationRepository {
    override fun getGasStations(onComplete: (List<GasStation>?) -> Unit, onError: (Throwable) -> Unit) {
        gasStationService
            .getGasStations()
            .enqueue(object : Callback<List<GasStation>> {
                override fun onFailure(call: Call<List<GasStation>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<GasStation>>, response: Response<List<GasStation>>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

}