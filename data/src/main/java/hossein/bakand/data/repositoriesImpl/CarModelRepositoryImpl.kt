package hossein.bakand.data.repositoriesImpl

import hossein.bakand.data.database.daos.CarModelDao
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.mappers.toEntity
import hossein.bakand.data.model.CarModel
import hossein.bakand.domain.repositories.CarModelRepository
import javax.inject.Inject

class CarModelRepositoryImpl @Inject constructor(
    private val carModelDao: CarModelDao
) : CarModelRepository {
    override suspend fun insertAndReplaceCarModel(carModel: CarModel) {
        carModelDao.insertCarModelBookMark(carModel.toEntity())
    }
}
