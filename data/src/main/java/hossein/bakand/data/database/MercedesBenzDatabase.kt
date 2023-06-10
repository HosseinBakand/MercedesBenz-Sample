    package hossein.bakand.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hossein.bakand.data.database.daos.MarketDao
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.database.utils.KernelTypeConverter

    @Database(
    entities = [
        MarketEntity::class
    ],
    version = 1,
)
@TypeConverters(
    KernelTypeConverter::class,
)
abstract class MercedesBenzDatabase : RoomDatabase() {
    abstract fun marketDao(): MarketDao
}
