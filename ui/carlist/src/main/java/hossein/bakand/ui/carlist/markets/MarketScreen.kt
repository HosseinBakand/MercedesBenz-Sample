package hossein.bakand.ui.carlist.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hossein.bakand.core.commonui.DevicePreviews
import hossein.bakand.core.commonui.component.BCTopAppBar
import hossein.bakand.core.commonui.theme.MercedesBenzTheme
import hossein.bakand.data.model.Market
import hossein.bakand.data.model.marketPreview

@Composable
fun MarketScreen(
    viewModel: MarketViewModel = hiltViewModel(), onMarketClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MarketScreen(
        uiState = uiState, onMarketClick = onMarketClick
    )
}

@Composable
fun MarketScreen(
    uiState: MarketUiState, onMarketClick: (String) -> Unit
) {
    Scaffold(modifier = Modifier.navigationBarsPadding(),
//        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            BCTopAppBar(
                title = "Markets"
            )
        }) { innerPadding ->
        if (uiState.markets is List<*>) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("book:chapter")
                    .padding(innerPadding)
//                    .consumedWindowInsets(innerPadding)
//                , contentPadding = PaddingValues(all = 16.dp)
            ) {

                itemsIndexed(uiState.markets) { index, market ->
                    MarketItem(market, onMarketClick)

                    if (index < uiState.markets.size) {
                        ContentDivider()
                    }
                }
            }
        } else {
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}



@Composable
private fun ContentDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun MarketItem(market: Market, onClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .clickable {
                onClick(market.marketId)
            }
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                modifier = Modifier, text = "Country: ",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier,
                text = market.country.title,
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier,
                text = "Language: ",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier,
                text = market.language.title,
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Kernel Type:",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
            Kernels(market.kernelType)
        }
    }
}

@Composable
fun Kernels(kernels: List<String>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(kernels) { kernel ->
            Text(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 6.dp, vertical = 2.dp),
                text = kernel,
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}


@DevicePreviews
@Composable
fun MarketScreenPreview() {


    MercedesBenzTheme() {
        Box(modifier = Modifier.background(Color.White)) {
            MarketScreen(uiState = MarketUiState(markets = marketPreview)) {

            }
//            MarketItem(marketPreview.first()) {}
        }
    }
}