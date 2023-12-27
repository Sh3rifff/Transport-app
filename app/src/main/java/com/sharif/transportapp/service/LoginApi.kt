package com.sharif.transportapp.service

import com.sharif.transportapp.model.LoginRequest
import com.sharif.transportapp.model.LoginResponse
import com.sharif.transportapp.model.RegisterRequest
import com.sharif.transportapp.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApi {

    @GET("api/xxx/xxx")
    suspend fun login(@Body body: LoginRequest): Response<LoginResponse>

    @POST("api/xxx/xxx")
    suspend fun register(@Body body: RegisterRequest): Response<RegisterResponse>

}