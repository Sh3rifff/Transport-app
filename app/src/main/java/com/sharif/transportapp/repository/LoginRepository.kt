package com.sharif.transportapp.repository

import com.sharif.transportapp.model.LoginRequest
import com.sharif.transportapp.model.RegisterRequest
import com.sharif.transportapp.service.LoginApi
import com.sharif.transportapp.util.RetrofitHelper
import java.lang.Exception

class LoginRepository {
    private val loginApi: LoginApi = RetrofitHelper.loginService

    suspend fun login(email: String, password: String): Boolean {
        return try {
            loginApi.login(LoginRequest(email, password))
            true
        } catch (exception: Exception) {
            false
        }
    }

    suspend fun register(
        name: String,
        email: String,
        password: String,
        passwordConfirm: String
    ): Boolean {
        return try {
            loginApi.register(RegisterRequest(name, email, password, passwordConfirm))
            true
        } catch (exception: Exception) {
            false
        }
    }
}