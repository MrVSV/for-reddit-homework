package com.example.unsplashhomework.data.api.interceptor

import android.util.Log
import com.example.humblrvsv.interceptor.AuthTokenProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val tokenProvider: AuthTokenProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.e("Kart", "интецептор токен = ${tokenProvider.getToken()}")
        val request = chain.request()
        if (chain.request().url.encodedPath != "https://oauth.reddit.com") {
            return chain.proceed(request)
        }
        val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer ${tokenProvider.getToken()}")
                .build()
        return chain.proceed(newRequest)
    }
}
