package com.example.pr1.services

import com.example.pr1.data.Product // Импортируем новый класс
import com.example.pr1.data.UsersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserInterface {
    @GET("users")
    suspend fun getAllUsers(): UsersResponse

    // Добавляем этот метод:
    @POST("products/add")
    suspend fun addProduct(@Body product: Product): Product
}
