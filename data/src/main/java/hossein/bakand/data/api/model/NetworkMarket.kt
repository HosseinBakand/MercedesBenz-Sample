package hossein.bakand.data.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class NetworkMarket (
    @SerialName("marketId")
    val marketID: String,

    val language: String,
    val country: String,
    val vbet: String? = null,
    val kernelType: List<KernelType>,

    @SerialName( "_links")
    val links: Links,

    @SerialName("gssnId")
    val gssnID: String? = null,

    val vanVbet: String? = null
)
@Serializable(KernelTypeSerializer::class)
enum class KernelType(val value: String) {
    C2("C2"),
    GCC("GCC"),
    Kbv("KBV");

    companion object {
        public fun fromValue(value: String): KernelType = when (value) {
            "C2"  -> C2
            "GCC" -> GCC
            "KBV" -> Kbv
            else  -> throw IllegalArgumentException()
        }
    }
}

@Serializable
data class Links (
    val self: String,
    val classes: String,
    val bodies: String,
    val models: String,
    @SerialName("productgroups")
    val productGroups: String
)

object KernelTypeSerializer : KSerializer<KernelType> {
    override fun deserialize(decoder: Decoder): KernelType =
        KernelType.fromValue(decoder.decodeString())

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(
        serialName = "kernelType",
        kind = PrimitiveKind.STRING,
    )

    override fun serialize(encoder: Encoder, value: KernelType) =
        encoder.encodeString(value.toString())
}
