package hossein.bakand.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class NetworkMarket (
    @SerialName("marketId")
    val marketID: String,
    val language: String,
    val country: String,
    val kernelType: List<String>,

)
