package hossein.bakand.domain.repositories

import hossein.bakand.data.model.CarModel

interface CarModelRepository{
    suspend fun toggleBookmarkCar(carModel: CarModel)
}