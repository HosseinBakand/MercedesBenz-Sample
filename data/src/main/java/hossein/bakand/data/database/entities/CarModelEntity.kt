package hossein.bakand.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import hossein.bakand.data.database.models.PriceDataModel
import hossein.bakand.data.database.models.VehicleBodyDataModel
import hossein.bakand.data.database.models.VehicleClassDataModel
import hossein.bakand.data.model.Price
import hossein.bakand.data.model.VehicleBody
import hossein.bakand.data.model.VehicleClass

@Entity(
    tableName = "car_models",
    primaryKeys = ["market_id", "model_id"]
)
data class CarModelEntity(
    @ColumnInfo(name="vehicle_sort_id")
    val vehicleSortID: Long,
    @ColumnInfo(name="market_id")
    val marketId: String,
    @ColumnInfo(name="model_id")
    val modelID: String,
    @ColumnInfo(name="internal_model_series")
    val internalModelSeries: String? = null,
    @ColumnInfo(name="type_class")
    val typeClass: String? = null,
    val name: String,
    @ColumnInfo(name="short_name")
    val shortName: String,
    val brand: String,
    @ColumnInfo(name="vehicle_class")
    val vehicleClass: VehicleClassDataModel,
    @ColumnInfo(name="vehicle_body")
    val vehicleBody: VehicleBodyDataModel,
    @ColumnInfo(name="model_year")
    val modelYear: String,
    @ColumnInfo(name="change_year")
    val changeYear: String? = null,
    @ColumnInfo(name="price_information")
    val priceInformation: PriceDataModel,
)
