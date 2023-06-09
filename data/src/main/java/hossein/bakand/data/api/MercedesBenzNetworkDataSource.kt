/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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