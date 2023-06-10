package hossein.bakand.data.database.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PriceDataModel (
    val price: Double,
    val currency: String,
)
@Serializable
data class VehicleBodyDataModel (
    @SerialName("bodyId")
    val bodyID: String,
    val bodyName: String,
)
@Serializable
data class VehicleClassDataModel (
    @SerialName("classId")
    val classID: String,
    val className: String,
)
