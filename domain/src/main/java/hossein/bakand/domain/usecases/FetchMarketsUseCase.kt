package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class FetchMarketsUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ResultUseCase<Unit,Boolean>(ioDispatcher) {

    override suspend fun doWork(params: Unit):Boolean {
        return marketRepository.updateMarkets()
    }
}
