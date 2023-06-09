package hossein.bakand.ui.carlist.markets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hossein.bakand.core.commonui.DevicePreviews
import hossein.bakand.data.model.Market
import hossein.bakand.data.model.marketPreview

@Composable
fun MarketScreen(
    viewModel: MarketViewModel = hiltViewModel(),
    onMarketClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MarketScreen(
        uiState = uiState,
        onMarketClick = onMarketClick
    )
}

@Composable
fun MarketScreen(
    uiState: MarketUiState,
    onMarketClick: (String) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
//        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBarWithNavigator()
        }
    ) { innerPadding ->
        if (uiState.markets is List<*>) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("book:chapter")
                    .padding(innerPadding)
//                    .consumedWindowInsets(innerPadding)
                ,
                contentPadding = PaddingValues(all = 16.dp)
            ) {

                itemsIndexed(uiState.markets) { index, market ->
                    val itemShape = RoundedCornerShape(
                        topStart = if (index == 0) 4.dp else 0.dp,
                        topEnd = if (index == 0) 4.dp else 0.dp,
                        bottomStart = if (index == uiState.markets.lastIndex) 4.dp else 0.dp,
                        bottomEnd = if (index == uiState.markets.lastIndex) 4.dp else 0.dp
                    )


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarWithNavigator(
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            TopAppBar(
                title = {
                    Text(text = "markets")
                },
            )
        }
    }
}


@Composable
private fun ContentDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp)
            .background(color = MaterialTheme.colorScheme.background)
    )
}

@Composable
fun MarketItem(market: Market, onClick: (String) -> Unit) {
    Text(
        modifier = Modifier.clickable {
            onClick(market.marketId)
        },
        text = market.marketId
    )
}


@DevicePreviews
@Composable
fun MarketScreenPreview() {

    MarketScreen(uiState = MarketUiState(markets = marketPreview)) {

    }
}