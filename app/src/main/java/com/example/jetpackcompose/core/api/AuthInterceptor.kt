package com.example.jetpackcompose.core.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI2NTFkNGE5YjUzNGQyOTI4Y2JiZWRhYzIiLCJ1c2VyVHlwZSI6MCwiaWF0IjoxNzA1MDQwODE3LCJleHAiOjIwMjA0MDA4MTcsImlzcyI6Imh0dHBzOi8vbmV0Y2xhbi5jb20ifQ.YanljjSeYW3wQhXiMXVejlJiG07y6heApSPYGQ6O-KM"
        request.addHeader("Authorization","Bearer $token")
        return chain.proceed(request.build())
    }
}