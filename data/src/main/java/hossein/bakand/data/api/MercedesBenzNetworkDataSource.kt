

package hossein.bakand.data.api

import javax.inject.Inject
import javax.inject.Singleton
import hossein.bakand.data.api.model.NetworkMarket



interface MercedesBenzNetworkDataSource {
    suspend fun getMarkets(): List<NetworkMarket>
}

@Singleton
class RetrofitMercedesBenzNetwork @Inject constructor(
    private val networkApi: MercedesBenzNiaNetworkApi
) : MercedesBenzNetworkDataSource {

    override suspend fun getMarkets(): List<NetworkMarket> {
        return networkApi.getMarkets()//.data
    }

}