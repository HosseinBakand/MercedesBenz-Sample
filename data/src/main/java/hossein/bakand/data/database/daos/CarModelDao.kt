package hossein.bakand.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import hossein.bakand.data.database.entities.CarModelEntity
import hossein.bakand.data.database.entities.MarketEntity

@Dao
interface CarModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarModelBookMark(carModelEntity: CarModelEntity)
}