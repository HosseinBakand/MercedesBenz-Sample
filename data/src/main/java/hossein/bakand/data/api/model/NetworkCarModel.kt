package hossein.bakand.data.api.model

import hossein.bakand.data.database.models.PriceDataModel
import hossein.bakand.data.database.models.VehicleBodyDataModel
import hossein.bakand.data.database.models.VehicleClassDataModel
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
    val vehicleClass: VehicleClassDataModel,
    val vehicleBody: VehicleBodyDataModel,
    val modelYear: String,
    val changeYear: String? = null,
    val priceInformation: PriceDataModel,
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
