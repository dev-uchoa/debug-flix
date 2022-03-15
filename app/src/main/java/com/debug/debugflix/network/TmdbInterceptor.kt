package com.debug.debugflix.network

import com.debug.debugflix.BuildConfig
import com.debug.debugflix.network.exception.NoNetworkConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class TmdbInterceptor(
    private val checkNetworkConnection: CheckNetworkConnection
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (checkNetworkConnection.isAvailable()) {
            val newUrl = chain.request().url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.tokenTMDB)
                .build()

            return chain.proceed(
                chain.request().newBuilder()
                    .url(newUrl)
                    .build()
            )
        } else {
            throw NoNetworkConnectionException()
        }
    }
}
