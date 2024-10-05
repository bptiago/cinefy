package com.puc.cinefy.movie.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Obter a requisição original
        val originalRequest = chain.request()

        // Criar uma nova requisição com o cabeçalho "Authorization" e o Bearer Token
        val newRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        // Prosseguir com a requisição modificada
        return chain.proceed(newRequest)
    }
}