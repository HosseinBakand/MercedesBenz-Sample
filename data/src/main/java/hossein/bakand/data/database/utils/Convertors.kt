package hossein.bakand.data.database.utils

import androidx.room.TypeConverter
import hossein.bakand.data.database.models.PriceDataModel
import hossein.bakand.data.database.models.VehicleBodyDataModel
import hossein.bakand.data.database.models.VehicleClassDataModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KernelTypeConverter {
    @TypeConverter
    fun stringToKernelType(value: String): List<String> = Json.decodeFromString(value)
    @TypeConverter
    fun kernelTypeToString(kernelType: List<String>): String = Json.encodeToString(kernelType)
}

class PriceDataModelConverter {
    @TypeConverter
    fun stringToKernelType(value: String): PriceDataModel = Json.decodeFromString(value)
    @TypeConverter
    fun kernelTypeToString(kernelType: PriceDataModel): String = Json.encodeToString(kernelType)
}

class VehicleBodyDataModelConverter {
    @TypeConverter
    fun stringToKernelType(value: String): VehicleBodyDataModel = Json.decodeFromString(value)
    @TypeConverter
    fun kernelTypeToString(kernelType: VehicleBodyDataModel): String = Json.encodeToString(kernelType)
}

class VehicleClassDataModelConverter {
    @TypeConverter
    fun stringToKernelType(value: String): VehicleClassDataModel = Json.decodeFromString(value)
    @TypeConverter
    fun kernelTypeToString(kernelType: VehicleClassDataModel): String = Json.encodeToString(kernelType)
}
