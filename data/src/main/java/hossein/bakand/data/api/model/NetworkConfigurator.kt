package hossein.bakand.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkConfigurator (
    @SerialName("marketId")
    val marketID: String,

    @SerialName( "modelId")
    val modelID: String,

    @SerialName( "configurationId")
    val configurationID: String,

    @SerialName( "vehicleSortId")
    val vehicleSortID: Long,

    val internalModelSeries: String,
    val context: Context,
    val initialPrice: Price,
    val configurationPrice: Price,
    val deltaExtraEquipmentPrice: Price,
    val modelYear: String,
    val changeYear: String? = null,
    val technicalInformation: TechnicalInformation,
    val validationStatus: ValidationStatus,

    @SerialName( "_links")
    val links: ImageLink
)
@Serializable
data class ImageLink (
    val image: String,
)
@Serializable
data class TechnicalInformation (
    val engine: Engine,
    val dimensions: Map<String, ValueWithUnit>,
    val acceleration: ValueWithUnit,
    val topSpeed: ValueWithUnit,
    val doors: Long,
    val seats: Long,
    val actualMass: ValueWithUnit,
    val weights: Weights,
)
@Serializable
data class ValueWithUnit (
    val value: Double,
    val unit: String
)
@Serializable
data class Engine (
    val fuelType: String,
    val engineConcept: String,
    val driveConcept: String,
    @SerialName( "powerHp")
    val powerHP: ValueWithUnit,
    val powerKw: ValueWithUnit,
    val cylinder: String,
    val capacity: ValueWithUnit,
    val emissionStandard: String,
    val engineSpeedMax: ValueWithUnit
)
@Serializable
data class Weights (
    val unloadedWeight: ValueWithUnit,
)
@Serializable
data class ValidationStatus (
    val valid: Boolean
)
