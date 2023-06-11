package hossein.bakand.data.mappers

import hossein.bakand.data.database.models.VehicleClassDataModel
import hossein.bakand.data.model.VehicleClass

fun VehicleClassDataModel.toModel() = VehicleClass(classID, className)
fun VehicleClass.toDataModel() = VehicleClassDataModel(classID, className)