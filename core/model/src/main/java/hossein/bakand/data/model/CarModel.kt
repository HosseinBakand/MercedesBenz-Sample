package hossein.bakand.data.model

data class CarModel(
    val vehicleSortID: Long,
    val marketId: String,
    val modelID: String,
    val internalModelSeries: String? = null,
    val typeClass: String? = null,
    val name: String,
    val shortName: String,
    val brand: String,
    val vehicleClass: VehicleClass,
    val vehicleBody: VehicleBody,
    val modelYear: String,
    val changeYear: String? = null,
    val priceInformation: Price,
)


val carModelPreview = listOf(
    CarModel(
        vehicleSortID = 1,
        marketId = "",
        modelID = "",
        internalModelSeries = "",
        typeClass = "",
        name = "Mercedes-AMG S-Class Sedan",
        shortName = "",
        brand = "",
        vehicleClass = VehicleClass("", "Mercedes-Benz"),
        vehicleBody = VehicleBody("", "Metal"),
        modelYear = "",
        changeYear = "",
        priceInformation = Price(155000.00, "Euro"),
    ),
    CarModel(
        vehicleSortID = 1,
        marketId = "",
        modelID = "",
        internalModelSeries = "",
        typeClass = "",
        name = "Mercedes-AMG S-Class Sedan",
        shortName = "",
        brand = "",
        vehicleClass = VehicleClass("", "Mercedes-Benz"),
        vehicleBody = VehicleBody("", "Metal"),
        modelYear = "",
        changeYear = "",
        priceInformation = Price(155000.00, "Euro"),
    ),
    CarModel(
        vehicleSortID = 1,
        marketId = "",
        modelID = "",
        internalModelSeries = "",
        typeClass = "",
        name = "Mercedes-AMG S-Class Sedan",
        shortName = "",
        brand = "",
        vehicleClass = VehicleClass("", "Mercedes-Benz"),
        vehicleBody = VehicleBody("", "Metal"),
        modelYear = "",
        changeYear = "",
        priceInformation = Price(155000.00, "Euro"),
    ),
    CarModel(
        vehicleSortID = 1,
        marketId = "",
        modelID = "",
        internalModelSeries = "",
        typeClass = "",
        name = "Mercedes-AMG S-Class Sedan",
        shortName = "",
        brand = "",
        vehicleClass = VehicleClass("", "Mercedes-Benz"),
        vehicleBody = VehicleBody("", "Metal"),
        modelYear = "",
        changeYear = "",
        priceInformation = Price(155000.00, "Euro"),
    ),
    CarModel(
        vehicleSortID = 1,
        marketId = "",
        modelID = "",
        internalModelSeries = "",
        typeClass = "",
        name = "Mercedes-AMG S-Class Sedan",
        shortName = "",
        brand = "",
        vehicleClass = VehicleClass("", "Mercedes-Benz"),
        vehicleBody = VehicleBody("", "Metal"),
        modelYear = "",
        changeYear = "",
        priceInformation = Price(155000.00, "Euro"),
    ),
)