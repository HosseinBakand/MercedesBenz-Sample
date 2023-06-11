package hossein.bakand.data.mappers

import hossein.bakand.data.database.models.PriceDataModel
import hossein.bakand.data.model.Price


fun PriceDataModel.toModel() = Price(price = price, currency = currency)

fun Price.toDataModel() = PriceDataModel(price = price, currency = currency)
