package hossein.bakand.domain.repositories

import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Market
import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    fun getAllMarket(): Flow<List<Market>>
    fun getMarketModels(marketId : String): Flow<List<CarModel>>
    suspend fun updateMarkets() : Boolean
    suspend fun getMarket(marketId : String): Market
    suspend fun fetchMarketCarModels(marketId: String) : Boolean
}