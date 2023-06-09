    package hossein.bakand.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hossein.bakand.data.database.daos.MarketDao
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.database.utils.KernelTypeConverter
import hossein.bakand.data.database.utils.LinksTypeConverter

    @Database(
    entities = [
        MarketEntity::class
    ],
    version = 1,
)
@TypeConverters(
    KernelTypeConverter::class,
    LinksTypeConverter::class,
)
abstract class MercedesBenzDatabase : RoomDatabase() {
    abstract fun marketDao(): MarketDao
}
