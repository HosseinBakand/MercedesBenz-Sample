package hossein.bakand.domain.usecases

import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.data.model.CarModel
import hossein.bakand.domain.repositories.CarModelRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ToggleBookmarkCarUseCase @Inject constructor(
    private val carModelRepository: CarModelRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : NoResultUseCase<CarModel>(ioDispatcher) {
    override suspend fun doWork(params: CarModel) {
        carModelRepository.insertAndReplaceCarModel(params.copy(isBookmarked = !params.isBookmarked))
    }

}
