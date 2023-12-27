package com.sharif.transportapp.service

import com.sharif.transportapp.model.StartDestinationModel
import retrofit2.Response
import retrofit2.http.GET

interface TransportApi {

    @GET("api/xxx/xxx")
    suspend fun destination(): Response<List<StartDestinationModel>>

}