package ru.marten.teacherapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.marten.teacherapplication.model.LoginRepository

class LoginViewModel(
    private val loginRepository: LoginRepository
): ViewModel() {

    val loginResult: MutableLiveData<String> = MutableLiveData()

    fun validatePassword(password: String): Boolean {
        return password.length > 8
    }

    fun login(login: String, password: String) {
        viewModelScope.launch {
            loginResult.postValue(loginRepository.login(login, password))
        }
    }

}