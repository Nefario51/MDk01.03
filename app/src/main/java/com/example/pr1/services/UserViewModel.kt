package com.example.pr1.services

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.Product
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
                Log.e("UserViewModel", "Ошибка Users: ${e.message}")
            }
        }
    }

    fun addNewProduct() {
        viewModelScope.launch {
            try {
                val targetProduct = Product(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf("Наушники", "bluetooth", "шумоподавление", "беспроводные наушники", "гаджеты")
                )

                Log.d("UserViewModel", "Отправка запроса на добавление товара...")
                val responseProduct = RetrofitClient.userApi.addProduct(targetProduct)

                Log.d("UserViewModel", " Товар успешно добавлен!")
                Log.d("UserViewModel", "ID товара: ${responseProduct.id}")
                Log.d("UserViewModel", "Название: ${responseProduct.title}")
                Log.d("UserViewModel", "Описание: ${responseProduct.description}")
                Log.d("UserViewModel", "Категория: ${responseProduct.category}")


            } catch (e: Exception) {
                Log.e("UserViewModel", "Ошибка при добавлении товара: ${e.message}")
            }
        }
    }
}
