package hossein.bakand.data.model

data class VehicleBody (
    val bodyID: String,
    val bodyName: String,
)

val vehicleBodyPreview = listOf(
    VehicleBody(bodyID= "1", bodyName = "Metal"),
    VehicleBody(bodyID= "2", bodyName = "Steel"),
    VehicleBody(bodyID= "3", bodyName = "glass"),
    VehicleBody(bodyID= "4", bodyName = "Metal"),
    VehicleBody(bodyID= "5", bodyName = "Metal"),
)