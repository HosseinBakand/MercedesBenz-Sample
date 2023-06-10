package hossein.bakand.data.api

import hossein.bakand.data.api.model.NetworkCarModel
import hossein.bakand.data.api.model.NetworkConfigurator
import hossein.bakand.data.api.model.NetworkMarket
import hossein.bakand.data.api.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MercedesBenzNiaNetworkApi {
    @GET(value = "markets")
    suspend fun getMarkets(): List<NetworkMarket>
    @GET(value = "markets/{market_id}")
    suspend fun getMarket(
        @Path(value = "market_id") marketId:String
    ): NetworkMarket
//    @GET(value = "markets/{market_id}/classes")
//    suspend fun getMarketClasses(
//        @Path(value = "market_id") marketId:String
//    ): NetworkMarket
//    @GET(value = "markets/{market_id}/bodies")
//    suspend fun getMarketBodies(
//        @Path(value = "market_id") marketId:String
//    ): NetworkMarket
    @GET(value = "markets/{market_id}/models")
    suspend fun getMarketModels(
        @Path(value = "market_id") marketId:String
    ): List<NetworkCarModel>
    @GET(value = "markets/{market_id}/models/{model_id}/configurations/initial")
    suspend fun getMarketProductGroups(
        @Path(value = "market_id") marketId:String,
        @Path(value = "model_id") ModelId:String
    ): NetworkConfigurator

}


