package hossein.bakand.domain.repositories

import hossein.bakand.data.model.Market
import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    fun getAllMarket(): Flow<List<Market>>
}