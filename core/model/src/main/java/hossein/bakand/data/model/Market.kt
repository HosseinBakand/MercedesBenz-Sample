package hossein.bakand.data.model

data class Market(
    val marketId: String,
    val language: String,
    val country: String,
//    val vbet: String,
    val kernelType: List<String>,
//    val self: String,
//    val classes: String,
//    val bodies: String,
//    val models: String,
//    val productgroups: String
)


val marketPreview = listOf(
    Market(marketId = "marketId1", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId2", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId3", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId4", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId5", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId6", language = "En", country = "En", kernelType = emptyList()),
    Market(marketId = "marketId7", language = "En", country = "En", kernelType = emptyList()),
)