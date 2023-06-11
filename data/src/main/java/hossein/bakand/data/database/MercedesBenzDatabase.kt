    package hossein.bakand.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hossein.bakand.data.database.daos.CarModelDao
import hossein.bakand.data.database.daos.MarketDao
import hossein.bakand.data.database.entities.CarModelEntity
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.database.utils.KernelTypeConverter
import hossein.bakand.data.database.utils.PriceDataModelConverter
import hossein.bakand.data.database.utils.VehicleBodyDataModelConverter
import hossein.bakand.data.database.utils.VehicleClassDataModelConverter

    @Database(
    entities = [
        MarketEntity::class,
        CarModelEntity::class,
    ],
    version = 1,
)
@TypeConverters(
    KernelTypeConverter::class,
    PriceDataModelConverter::class,
    VehicleBodyDataModelConverter::class,
    VehicleClassDataModelConverter::class
)
abstract class MercedesBenzDatabase : RoomDatabase() {
    abstract fun marketDao(): MarketDao
    abstract fun carModelDao(): CarModelDao
}
