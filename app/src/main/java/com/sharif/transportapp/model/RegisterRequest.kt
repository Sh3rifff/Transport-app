package com.sharif.transportapp.model

class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
)