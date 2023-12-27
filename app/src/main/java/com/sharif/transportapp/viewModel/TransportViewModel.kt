package com.sharif.transportapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharif.transportapp.model.RecyclerItemModel
import com.sharif.transportapp.model.StartDestinationModel
import com.sharif.transportapp.repository.TransportRepository
import kotlinx.coroutines.launch

class TransportViewModel : ViewModel() {

    private val transportRepository = TransportRepository()

    private val _isDestination = MutableLiveData<List<StartDestinationModel>>()
    val isDestination: LiveData<List<StartDestinationModel>> = _isDestination

    private val _transport = MutableLiveData<List<RecyclerItemModel>>()
    val transport: LiveData<List<RecyclerItemModel>> = _transport

    fun startDestination() {
        viewModelScope.launch {
            _isDestination.value = transportRepository.getStartDestinations()
        }
    }

    init {
        refreshDestinations()
    }

    private fun refreshDestinations() {

        val transport1 = RecyclerItemModel("Baku", "Aze", "Izmir", "Tur", "11.05.2023")
        val transport2 = RecyclerItemModel("Ganja", "Aze", "Tehran", "Iran", "20.10.2024")
        val transport3 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")
        val transport4 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")
        val transport5 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")
        val transport7 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")
        val transport8 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")
        val transport9 = RecyclerItemModel("London", "Eng", "Paris", "Fra", "21.01.2024")

        val data = arrayListOf(
            transport1,
            transport2,
            transport3,
            transport4,
            transport5,
            transport7,
            transport8,
            transport9
        )

        _transport.value = data
    }
}