package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMarketCarModelsUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SubjectUseCase<String,List<CarModel>>(ioDispatcher) {
    override fun createObservable(params: String): Flow<List<CarModel>> {
        return marketRepository.getMarketModels(params)
    }

}
