package hossein.bakand.data.mappers

import hossein.bakand.data.api.model.NetworkMarket
import hossein.bakand.data.database.entities.MarketEntity
import hossein.bakand.data.model.Country
import hossein.bakand.data.model.Language
import hossein.bakand.data.model.Market

fun NetworkMarket.toEntity() = MarketEntity(
    marketId = marketID,
    language = language,
    country = country,
    kernelType = kernelType,
)
fun MarketEntity.toModel() = Market(
    marketId = marketId,
    language = Language.valueOf(language),
    country = Country.valueOf(country),
    kernelType = kernelType,
)