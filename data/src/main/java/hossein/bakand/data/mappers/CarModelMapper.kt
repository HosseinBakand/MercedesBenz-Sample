package hossein.bakand.data.mappers

import hossein.bakand.data.api.model.NetworkCarModel
import hossein.bakand.data.database.entities.CarModelEntity
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Price
import hossein.bakand.data.model.VehicleBody

fun NetworkCarModel.toModel() = CarModel(
    vehicleSortID = vehicleSortID,
    marketId = context.market.marketID,
    modelID = modelID,
    internalModelSeries = internalModelSeries,
//    typeClass = typeClass,
    name = name,
    shortName = shortName,
    brand = brand.name,
    vehicleClass = vehicleClass.toModel(),
    vehicleBody = vehicleBody.toModel(),
    modelYear = modelYear,
    changeYear = changeYear,
    priceInformation = priceInformation.toModel(),
)

fun NetworkCarModel.toEntity() = CarModelEntity(
    vehicleSortID = vehicleSortID,
    marketId = context.market.marketID,
    modelID = modelID,
    internalModelSeries = internalModelSeries,
    typeClass = typeClass,
    name = name,
    shortName = shortName,
    brand = brand.name,
    vehicleClass = vehicleClass,
    vehicleBody = vehicleBody,
    modelYear = modelYear,
    changeYear = changeYear,
    priceInformation = priceInformation,
)

fun CarModelEntity.toModel() = CarModel(
    vehicleSortID = vehicleSortID,
    marketId = marketId,
    modelID = modelID,
    internalModelSeries = internalModelSeries,
//    typeClass = typeClass,
    name = name,
    shortName = shortName,
    brand = brand,
    vehicleClass = vehicleClass.toModel(),
    vehicleBody = vehicleBody.toModel(),
    modelYear = modelYear,
    changeYear = changeYear,
    priceInformation = priceInformation.toModel(),
)