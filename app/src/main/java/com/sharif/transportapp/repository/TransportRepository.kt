package com.sharif.transportapp.repository

import com.sharif.transportapp.model.StartDestinationModel
import com.sharif.transportapp.util.RetrofitHelper


class TransportRepository {

    private val destination = RetrofitHelper.destinations

    suspend fun getStartDestinations(): List<StartDestinationModel> {
        val response = destination.destination()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

}