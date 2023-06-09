package hossein.bakand.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import hossein.bakand.data.api.model.KernelType
import hossein.bakand.data.api.model.Links

@Entity(tableName = "markets")
data class MarketEntity(
    @PrimaryKey
    val marketId: String,
    val language: String,
    val country: String,
//    val kernelType: List<KernelType>,
    val links: Links,
)