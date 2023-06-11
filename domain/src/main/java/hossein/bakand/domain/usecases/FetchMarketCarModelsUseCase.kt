package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FetchMarketCarModelsUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ResultUseCase<String, Boolean>(ioDispatcher) {

    override suspend fun doWork(params: String): Boolean {
        return marketRepository.fetchMarketCarModels(params)
    }
}
