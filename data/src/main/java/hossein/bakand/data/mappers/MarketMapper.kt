package hossein.bakand.data.mappers

import hossein.bakand.data.api.model.NetworkMarket
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.model.Market

fun NetworkMarket.toEntity() = MarketEntity(
    marketId = marketID,
    language = language,
    country = country,
//    kernelType = kernelType,
    links = links,
)
fun MarketEntity.toModel() = Market(
    marketId = marketId,
    language = language,
    country = country,
//    kernelType = kernelType,
    selfUrl = links.self,
    classesUrl = links.classes,
    bodiesUrl = links.bodies,
    modelsUrl = links.models,
    productGroupsUrl = links.productGroups
)