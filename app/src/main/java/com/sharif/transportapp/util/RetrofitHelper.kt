package com.sharif.transportapp.util

import com.sharif.transportapp.service.LoginApi
import com.sharif.transportapp.service.TransportApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL = "http://xxxx"

    private val retrofitLogin = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService: LoginApi by lazy {
        retrofitLogin.create(LoginApi::class.java)
    }

    private val retrofitTransport = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val destinations: TransportApi = retrofitTransport.create(TransportApi::class.java)
}