package hossein.bakand.data.repositoriesImpl

import hossein.bakand.data.api.MercedesBenzNetworkDataSource
import hossein.bakand.data.api.model.NetworkMarket
import hossein.bakand.data.database.daos.MarketDao
import hossein.bakand.data.mappers.toEntity
import hossein.bakand.data.mappers.toModel
import hossein.bakand.data.model.Market
import hossein.bakand.data.model.marketPreview
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val mercedesBenzNetworkDataSource: MercedesBenzNetworkDataSource,
    private val marketDao: MarketDao,
) : MarketRepository {
    override fun getAllMarket(): Flow<List<Market>> {
        return marketDao.getMarkets().map { markets -> markets.map { it.toModel() } }
    }

    override suspend fun updateMarkets() {
        val markets = mercedesBenzNetworkDataSource.getMarkets().map(NetworkMarket::toEntity)
        marketDao.insertMarkets(markets)
    }
}