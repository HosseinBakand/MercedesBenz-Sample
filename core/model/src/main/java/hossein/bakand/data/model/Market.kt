package hossein.bakand.data.model

data class Market(
    val marketId: String,
    val language: String,
    val country: String,
//    val vbet: String,
//    val kernelType: List<String>,
    val selfUrl: String,
    val classesUrl: String,
    val bodiesUrl: String,
    val modelsUrl: String,
    val productGroupsUrl: String
)


val marketPreview = listOf(
    Market(marketId = "marketId1", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId2", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId3", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId4", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId5", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId6", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
    Market(marketId = "marketId7", language = "En", country = "En", selfUrl = "", classesUrl = "", bodiesUrl = "", modelsUrl = "", productGroupsUrl = "",),
)