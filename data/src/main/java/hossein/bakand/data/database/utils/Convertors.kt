package hossein.bakand.data.database.utils

import androidx.room.TypeConverter
import hossein.bakand.data.api.model.KernelType
import hossein.bakand.data.api.model.Links
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KernelTypeConverter {
    @TypeConverter
    fun stringToKernelType(value: String): KernelType = KernelType.valueOf(value)

    @TypeConverter
    fun kernelTypeToString(kernelType: KernelType): String = kernelType.value
}

class LinksTypeConverter {
    @TypeConverter
    fun linksToString(value: Links): String = Json.encodeToString(value)

    @TypeConverter
    fun stringToLinks(serializedLinks: String): Links = Json.decodeFromString(serializedLinks)
}