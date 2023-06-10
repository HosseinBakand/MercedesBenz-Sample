package hossein.bakand.ui.carlist.models

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hossein.bakand.core.commonui.DevicePreviews
import hossein.bakand.core.commonui.component.BCTopAppBar
import hossein.bakand.core.commonui.R
import hossein.bakand.core.commonui.theme.MercedesBenzTheme
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.carModelPreview
import hossein.bakand.ui.carlist.markets.MarketViewModel

@Composable
fun CarListScreen(
    viewModel: CarListViewModel = hiltViewModel(), onCarClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CarListScreen(uiState)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarListScreen(uiState: CarListUiState) {
    Scaffold(modifier = Modifier.navigationBarsPadding(), topBar = {
        BCTopAppBar(title = "Models")
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            var selectedTabIndex by remember { mutableStateOf(0) }
            val titles = listOf("A-Class", "C-Class", "S-Class")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                Text(modifier = Modifier.weight(1f), text = "Search")
                Text(text = "Filter")
            }
            MBTabRow(selectedTabIndex = selectedTabIndex) {
                titles.forEachIndexed { index, title ->
                    MBTab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(text = title) },
                    )
                }
            }
//            BrandsComponent(brands = emptyList())
            CarsComponent(cars = uiState.carModels)
        }
    }
}

//@Composable
//fun BrandsComponent(brands: List<Brand>) {
//
//}

@Composable
fun CarsComponent(cars: List<CarModel>) {
    LazyColumn(content = {
        items(cars) { car ->
            CarItem(car)
        }
    })
}

@Composable
fun CarItem(carModel: CarModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE2E2E2), shape = MaterialTheme.shapes.extraLarge
                ),
            painter = painterResource(id = R.drawable.ic_default_vehicle),
            contentDescription = null
        )
        Text(
            modifier = Modifier,
            text = carModel.name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier,
            text = carModel.priceInformation.price.toString(),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MBTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = {
            val style = MaterialTheme.typography.labelLarge.copy(textAlign = TextAlign.Center)
            ProvideTextStyle(
                value = style,
                content = {
                    Box(modifier = Modifier.padding(top = 8.dp)) {
                        text()
                    }
                },
            )
        },
    )
}

@Composable
fun MBTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onSurface,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 2.dp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
        tabs = tabs,
    )
}


@Composable
@DevicePreviews
fun CarListPreview() {
    MercedesBenzTheme() {
        Box(modifier = Modifier.background(Color.White)) {
            CarsComponent(carModelPreview)
        }
    }
}