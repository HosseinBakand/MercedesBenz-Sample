package hossein.bakand.ui.carlist.models

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

@Composable
fun CarListScreen(
    viewModel: CarListViewModel = hiltViewModel(),
    onCarClick: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showFilterDialog by rememberSaveable {
        mutableStateOf(false)
    }
    CarListScreen(
        uiState = uiState,
        onSelectClass = viewModel::setSelectedClass,
        onBookmarkCar = viewModel::bookmarkCar,
        onFilterClick = {
            showFilterDialog = true
        }
    )

    if (showFilterDialog) {
        FilterDialog(onDismiss = { showFilterDialog = false })
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarListScreen(
    uiState: CarListUiState,
    onSelectClass: (Int) -> Unit,
    onFilterClick: () -> Unit,
    onBookmarkCar: (CarModel) -> Unit
) {
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            BCTopAppBar(title = "Models")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = MaterialTheme.colorScheme.secondary,
                            shape = MaterialTheme.shapes.medium
                        ), text = "Search"
                )
                Button(onClick = onFilterClick) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Filter"
                    )
                }
            }

            val classes = uiState.carClasses
            if (classes.size > 1) {
                MBTabRow(selectedTabIndex = uiState.selectedClassInx) {
                    classes.forEachIndexed { index, carClass ->
                        MBTab(
                            selected = uiState.selectedClassInx == index,
                            onClick = { onSelectClass(index) },
                            text = { Text(text = carClass.className) },
                        )
                    }
                }
            }
            CarsComponent(cars = uiState.carModels, onBookmarkCar = onBookmarkCar)
        }
    }
}

@Composable
fun CarsComponent(cars: List<CarModel>, onBookmarkCar: (CarModel) -> Unit) {
    LazyColumn(content = {
        items(cars) { car ->
            CarItem(car) {
                onBookmarkCar(car)
            }
        }
    })
}

@Composable
fun CarItem(
    carModel: CarModel,
    onBookmarkClick: () -> Unit
) {
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

        IconButton(onClick = onBookmarkClick) {
            Icon(
                painter = painterResource(
                    if (carModel.isBookmarked) hossein.bakand.ui.carlist.R.drawable.ic_bookmark_enabled
                    else hossein.bakand.ui.carlist.R.drawable.ic_bookmark_disabled
                ),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
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
        modifier = modifier,
        selected = selected,
        onClick = onClick,
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
    ScrollableTabRow(
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
            CarsComponent(carModelPreview) {

            }
        }
    }
}