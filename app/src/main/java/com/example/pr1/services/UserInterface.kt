package com.example.pr1.services

import com.example.pr1.data.UsersResponse
import retrofit2.http.GET

interface UserInterface {
    @GET("users")
    suspend fun getAllUsers(): UsersResponse
}