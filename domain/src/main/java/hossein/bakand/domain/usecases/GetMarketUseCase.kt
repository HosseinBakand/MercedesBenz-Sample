package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMarketUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ResultUseCase<String,Market>(ioDispatcher) {
    override suspend fun doWork(params: String): Market {
        return marketRepository.getMarket(params)
    }
}
