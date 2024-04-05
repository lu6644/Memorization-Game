package com.example.memorizationgame.UI.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorizationgame.App
import com.example.memorizationgame.Business.UerAccount
import com.example.memorizationgame.Data.UserDao
import com.example.memorizationgame.Data.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableLiveData<UerAccount>()
    val user: LiveData<UerAccount> = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error



    fun createUser(newUser: UerAccount) {
        viewModelScope.launch {
            val result = userRepository.createUser(newUser)
            result.onSuccess { uid ->
                if (uid >= 0L) {
                    newUser.uid = uid
                    _user.value = newUser
                }
                else if (uid == -1L) {
                    _error.value = "This Username already exists"
                }
            }.onFailure { exception ->
                _error.value = exception.message ?: "An unknown error occurred"
            }
        }
    }
}
