package hossein.bakand.data.api.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    val data: T,
)