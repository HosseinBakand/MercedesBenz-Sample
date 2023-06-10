package hossein.bakand.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hossein.bakand.data.database.entities.MarketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMarkets(marketEntities: List<MarketEntity>)

    @Query("SELECT * FROM markets")
    fun getMarkets(): Flow<List<MarketEntity>>
}