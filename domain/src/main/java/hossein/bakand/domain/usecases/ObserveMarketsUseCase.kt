package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveMarketsUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ObservableUseCase<List<Market>>(ioDispatcher) {
    override fun createObservable(): Flow<List<Market>> {
        return  marketRepository.getAllMarket()
    }
}
