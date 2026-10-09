package com.example.pr1.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val appProxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(appProxy)
        .build()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userApi: UserInterface = retrofit.create(UserInterface::class.java)
}