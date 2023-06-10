package hossein.bakand.data.database.utils

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KernelTypeConverter {
    @TypeConverter
    fun stringToKernelType(value: String): List<String> = Json.decodeFromString(value)

    @TypeConverter
    fun kernelTypeToString(kernelType: List<String>): String = Json.encodeToString(kernelType)
}
