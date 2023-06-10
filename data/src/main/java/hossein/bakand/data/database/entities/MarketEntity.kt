package hossein.bakand.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "markets")
data class MarketEntity(
    @PrimaryKey
    val marketId: String,
    val language: String,
    val country: String,
    @ColumnInfo(name= "kernel_name")
    val kernelType: List<String>,
)