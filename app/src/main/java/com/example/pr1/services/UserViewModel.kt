package com.example.pr1.services

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val usersResponse = RetrofitClient.userApi.getAllUsers()
                for (user in usersResponse.users) {
                    Log.d(
                        "UserViewModel",
                        "Имя - ${user.firstName} ${user.lastName}  " +
                                "Email - ${user.email}  " +
                                "Дата рождения - ${user.birthDate}"
                    )
                }
            } catch (e: Exception) {
                Log.e("UserViewModel", e.message.toString())
            }
        }
    }
}