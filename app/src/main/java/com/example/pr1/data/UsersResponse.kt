package com.example.pr1.data

data class UsersResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)