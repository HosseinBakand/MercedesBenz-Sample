package hossein.bakand.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hossein.bakand.data.database.entities.CarModelEntity
import hossein.bakand.data.database.entities.MarketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarkets(marketEntities: List<MarketEntity>)

    @Query("SELECT * FROM markets")
    fun getMarkets(): Flow<List<MarketEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)//todo thick
    suspend fun insertCarModels(marketEntities: List<CarModelEntity>)

    @Query("SELECT * FROM car_models WHERE market_id = :marketId")
    fun getMarketCarModels(marketId:String): Flow<List<CarModelEntity>>
}