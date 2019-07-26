package br.com.heiderlopes.calculaflextestes.ui.gasstations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.calculaflextestes.model.GasStation
import br.com.heiderlopes.calculaflextestes.repository.GasStationRepository

class GasStationsViewModel(
    val gasStationRepository: GasStationRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val gasStations = MutableLiveData<List<GasStation>>()
    val messageError = MutableLiveData<String>()

    fun getGasStations() {
        isLoading.value = true
        gasStationRepository.getGasStations(
            onComplete = {
                isLoading.value = false
                gasStations.value = it
                messageError.value = ""
            },
            onError = {
                isLoading.value = false
                gasStations.value = listOf()
                messageError.value = it.message

            }
        )
    }
}