package hossein.bakand.data.repositoriesImpl

import hossein.bakand.data.api.MercedesBenzNetworkDataSource
import hossein.bakand.data.model.Market
import hossein.bakand.data.model.marketPreview
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val mercedesBenzNetworkDataSource: MercedesBenzNetworkDataSource
): MarketRepository {
    override fun getAllMarket(): Flow<List<Market>> {
        return flow {
            mercedesBenzNetworkDataSource.getMarkets()
            emit(marketPreview)
        }
    }
}