package com.sharif.transportapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharif.transportapp.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginRepository = LoginRepository()

    private val _isLoggedIn = MutableLiveData(false)
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    private val _isRegister = MutableLiveData(false)
    val isRegister: LiveData<Boolean> = _isRegister

    fun login(email: String, password: String) {

        viewModelScope.launch {
            _isLoggedIn.value = loginRepository.login(email, password)
        }

    }

    fun register(name: String, email: String, password: String, passwordConfirm: String) {

        viewModelScope.launch {
            _isRegister.value = loginRepository.register(name, email, password, passwordConfirm)
        }
    }
}