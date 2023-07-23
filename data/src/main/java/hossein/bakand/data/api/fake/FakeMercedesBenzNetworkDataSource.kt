package hossein.bakand.data.api.fake

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.data.api.MercedesBenzNetworkDataSource
import hossein.bakand.data.api.model.NetworkCarModel
import hossein.bakand.data.api.model.NetworkConfigurator
import hossein.bakand.data.api.model.NetworkMarket
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class FakeMercedesBenzNetworkDataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager,
) : MercedesBenzNetworkDataSource {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getMarkets(): List<NetworkMarket> =
        withContext(ioDispatcher) {
            assets.open(MARKETS_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getMarket(marketId: String): NetworkMarket =
        getMarkets().find { it.marketID == marketId }!!

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getMarketModels(marketId: String): List<NetworkCarModel> =
        withContext(ioDispatcher) {
            assets.open(MARKETS_MODELS_ASSET).use(networkJson::decodeFromStream)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getMarketProductGroups(
        marketId: String,
        ModelId: String
    ): NetworkConfigurator =
        withContext(ioDispatcher) {
            assets.open(MARKETS_MODELS_CONFIGURATIONS_ASSET).use(networkJson::decodeFromStream)
        }

    companion object {
        private const val MARKETS_ASSET = "v1-markets.json"
        private const val MARKETS_MODELS_ASSET = "v1-markets-de_DE-models.json"
        private const val MARKETS_MODELS_CONFIGURATIONS_ASSET = "v1-markets-de_De-models-1770511-configurations-initial.json"
    }
}
//
///**
// * Converts a list of [T] to change list of all the items in it where [idGetter] defines the
// * [NetworkChangeList.id]
// */
//private fun <T> List<T>.mapToChangeList(
//    idGetter: (T) -> String,
//) = mapIndexed { index, item ->
//    NetworkChangeList(
//        id = idGetter(item),
//        changeListVersion = index,
//        isDelete = false,
//    )
//}
