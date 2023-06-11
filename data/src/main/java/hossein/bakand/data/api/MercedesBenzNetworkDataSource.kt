package hossein.bakand.data.api

import hossein.bakand.data.api.model.NetworkCarModel
import hossein.bakand.data.api.model.NetworkConfigurator
import javax.inject.Inject
import javax.inject.Singleton
import hossein.bakand.data.api.model.NetworkMarket
import retrofit2.http.GET
import retrofit2.http.Path

interface MercedesBenzNetworkDataSource {
    suspend fun getMarkets(): List<NetworkMarket>
    suspend fun getMarket(marketId: String): NetworkMarket
    suspend fun getMarketModels(marketId: String): List<NetworkCarModel>

    suspend fun getMarketProductGroups(marketId: String, ModelId: String): NetworkConfigurator
}

@Singleton
class RetrofitMercedesBenzNetwork @Inject constructor(
    private val networkApi: MercedesBenzNiaNetworkApi
) : MercedesBenzNetworkDataSource {

    override suspend fun getMarkets(): List<NetworkMarket> {
//        networkApi.getMarketModels("en_AM")
//        networkApi.getMarketProductGroups("de_DE", "1771511")
        return networkApi.getMarkets()//.data
    }

    override suspend fun getMarket(marketId: String): NetworkMarket {
        return networkApi.getMarket(marketId)
    }

    override suspend fun getMarketModels(marketId: String): List<NetworkCarModel> {
        return networkApi.getMarketModels(marketId)
    }

    override suspend fun getMarketProductGroups(
        marketId: String,
        ModelId: String
    ): NetworkConfigurator {
        return networkApi.getMarketProductGroups(marketId, ModelId)
    }

}