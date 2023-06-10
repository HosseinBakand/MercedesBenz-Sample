package hossein.bakand.data.model

data class Market(
    val marketId: String,
    val language: Language,
    val country: Country,
    val kernelType: List<String>,
)


val marketPreview = listOf(
    Market(marketId = "marketId1", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId2", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId3", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId4", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId5", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId6", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
    Market(marketId = "marketId7", language = Language.EN, country = Country.US, kernelType = listOf("Knn")),
)