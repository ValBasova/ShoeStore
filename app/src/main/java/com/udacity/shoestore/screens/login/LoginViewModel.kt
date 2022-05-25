package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    //    val user = MutableLiveData<User>()
    val name = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _eventUserLogin = MutableLiveData<Boolean>()
    val eventUserLogin: LiveData<Boolean>
        get() = _eventUserLogin

    fun onLogin() {
        val loginName = name.value ?: ""
        val loginPassword = password.value ?: ""
        _eventUserLogin.value = loginName != "" && loginPassword != ""
    }

    fun onLoginComplete() {
        _eventUserLogin.value = false
    }
}