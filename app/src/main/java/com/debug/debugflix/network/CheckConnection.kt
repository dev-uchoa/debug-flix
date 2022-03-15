package com.debug.debugflix.network

import android.content.Context
import android.net.ConnectivityManager

class CheckNetworkConnection(
    private val context: Context
) {
    fun isAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) != null
    }
}