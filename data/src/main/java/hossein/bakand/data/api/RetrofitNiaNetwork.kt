package hossein.bakand.data.api

import hossein.bakand.data.api.model.NetworkMarket
import hossein.bakand.data.api.model.NetworkResponse
import retrofit2.http.GET

interface MercedesBenzNiaNetworkApi {
    @GET(value = "markets")
    suspend fun getMarkets(): List<NetworkMarket>
}


