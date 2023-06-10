package hossein.bakand.data.mappers

import hossein.bakand.data.database.models.VehicleBodyDataModel
import hossein.bakand.data.model.VehicleBody

fun VehicleBodyDataModel.toModel()= VehicleBody (bodyID, bodyName)