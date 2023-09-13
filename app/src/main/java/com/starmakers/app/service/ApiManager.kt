package com.starmakers.app.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val BASE_URL = "https://6976-2405-201-d02f-a8c8-9c5a-2726-33b9-6860.ngrok-free.app"

    // API response interceptor
    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    // Client
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val  apiInterface : ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client)
            .build()
            .create(ApiInterface::class.java)
    }

    fun getImageUrl(imagePath: String): String {
        return BASE_URL + imagePath
    }
}