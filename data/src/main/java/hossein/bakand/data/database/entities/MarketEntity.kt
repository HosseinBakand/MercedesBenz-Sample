package hossein.bakand.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "markets")
data class Market(
    @PrimaryKey
    val marketId: String,
    val language: String,
    val country: String,
    val kernelType: List<String>,
)
