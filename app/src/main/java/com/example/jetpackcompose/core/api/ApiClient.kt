package com.example.jetpackcompose.core.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL: String = "https://dev.netclan.com/devApi/api/"


    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        val authInterceptor = AuthInterceptor()
        val httpClient = OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.MINUTES)
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.MINUTES)
            .writeTimeout(20, TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
        if (authInterceptor != null) {
            httpClient.addInterceptor(authInterceptor)
        }


        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        }
        return retrofit
    }
}