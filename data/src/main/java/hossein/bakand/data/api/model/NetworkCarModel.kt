package hossein.bakand.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCarModel (
    @SerialName("vehicleSortId")
    val vehicleSortID: Long,
    val context: Context,
    @SerialName("modelId")
    val modelID: String,
    val internalModelSeries: String? = null,
    val typeClass: String? = null,
    val name: String,
    val shortName: String,
    val brand: Brand,
    val vehicleClass: VehicleClass,
    val vehicleBody: VehicleBody,
    val modelYear: String,
    val changeYear: String? = null,
    val priceInformation: Price,
)
@Serializable
data class Brand (
    val name: String
)

@Serializable
data class Context (
    val market: Market,
)
@Serializable
data class Market (
     @SerialName("marketId")
    val marketID: String,
)
@Serializable
data class Price (
    val price: Double,
    val currency: String,
)
//@Serializable
//enum class Currency(val value: String) {
//    Eur("EUR");
//
//    companion object {
//        public fun fromValue(value: String): Currency = when (value) {
//            "EUR" -> Eur
//            else  -> throw IllegalArgumentException()
//        }
//    }
//}
@Serializable
data class VehicleBody (
     @SerialName("bodyId")
    val bodyID: String,
    val bodyName: String,

)
@Serializable
data class VehicleClass (
     @SerialName("classId")
    val classID: String,
    val className: String,
)
