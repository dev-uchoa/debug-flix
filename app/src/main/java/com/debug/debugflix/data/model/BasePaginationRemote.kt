package com.debug.debugflix.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasePaginationRemote<out T>(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: T,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)