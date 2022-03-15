package com.debug.debugflix.network.extension

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.Response

inline fun <reified ClassType> Response.parseResponseBody(): ClassType? {
    return body?.let { body ->
        Json {
            ignoreUnknownKeys = true
        }.decodeFromString(body.string())
    }
}