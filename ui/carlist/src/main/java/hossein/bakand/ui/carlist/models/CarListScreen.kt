package hossein.bakand.ui.carlist.models

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hossein.bakand.core.commonui.DevicePreviews
import hossein.bakand.core.commonui.component.BCTopAppBar
import hossein.bakand.core.commonui.theme.MercedesBenzTheme
import hossein.bakand.data.model.CarModel
import hossein.bakand.ui.carlist.markets.countryCodeToFlagEmoji

@Composable
fun CarListScreen(
    viewModel: CarListViewModel = hiltViewModel(),
    onCarClick: (String) -> Unit,
    onBackClick: () -> Unit,
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
        },
        onBackClick = onBackClick
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
    onBackClick: () -> Unit,
    onBookmarkCar: (CarModel) -> Unit
) {
    Scaffold(modifier = Modifier
        .navigationBarsPadding()
        .background(color = MaterialTheme.colorScheme.background),
        topBar = {
            val marketTitle  = uiState.market?.country?.let{
                it.title + " Market " + countryCodeToFlagEmoji(it.code)
            }?:""
            BCTopAppBar(title = marketTitle, onBackClick = onBackClick)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                SearchTextField(onSearchQueryChanged = {}, searchQuery = "", onSearchTriggered = {})
                IconButton(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .background(
                            MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small
                        )
                        .padding(4.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                    onClick = onFilterClick,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .padding(4.dp),
                        painter = painterResource(hossein.bakand.ui.carlist.R.drawable.ic_filter),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
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


@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RowScope.SearchTextField(
    onSearchQueryChanged: (String) -> Unit,
    searchQuery: String,
    onSearchTriggered: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    val onSearchExplicitlyTriggered = {
        keyboardController?.hide()
        onSearchTriggered(searchQuery)
    }
    val searchIcon = painterResource(id = hossein.bakand.ui.carlist.R.drawable.ic_search)
    val closeIcon = painterResource(id = hossein.bakand.ui.carlist.R.drawable.ic_close)

    TextField(
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color(0xFFEEEEEF),
            unfocusedContainerColor = Color(0xFFEEEEEF)
        ),
        leadingIcon = {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = searchIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(
                    onClick = {
                        onSearchQueryChanged("")
                    },
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = closeIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
        onValueChange = {
            if (!it.contains("\n")) {
                onSearchQueryChanged(it)
            }
        },
        modifier = Modifier
            .weight(1f)
            .padding(16.dp)
            .focusRequester(focusRequester)
            .onKeyEvent {
                if (it.key == Key.Enter) {
                    onSearchExplicitlyTriggered()
                    true
                } else {
                    false
                }
            }
            .testTag("searchTextField"),
        shape = MaterialTheme.shapes.small,
        value = searchQuery,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchExplicitlyTriggered()
            },
        ),
        maxLines = 1,
        singleLine = true,
    )
}

@Composable
fun CarsComponent(cars: List<CarModel>, onBookmarkCar: (CarModel) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(8.dp), content = {
        items(cars) { car ->
            CarItem(car) {
                onBookmarkCar(car)
            }
        }
    })
}

@Composable
fun CarItem(
    carModel: CarModel, onBookmarkClick: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .border(width = 1.dp, color = Color(0xFFEEEEEF), shape = MaterialTheme.shapes.large)
        .clip(shape = MaterialTheme.shapes.large)
        .clickable { }
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = carModel.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = onBookmarkClick) {
                Icon(
                    painter = painterResource(
                        if (carModel.isBookmarked) hossein.bakand.ui.carlist.R.drawable.ic_bookmark_enabled
                        else hossein.bakand.ui.carlist.R.drawable.ic_bookmark_disabled
                    ), contentDescription = null, tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                painter = painterResource(hossein.bakand.ui.carlist.R.drawable.ic_brand),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier,
                text = carModel.brand,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = MaterialTheme.shapes.large
                    )
                    .padding(horizontal = 8.dp, vertical = 2.dp),
                text = carModel.vehicleClass.className,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondary,

                )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                painter = painterResource(hossein.bakand.ui.carlist.R.drawable.ic_vehicle_body),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier,
                text = carModel.vehicleBody.bodyName,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                painter = painterResource(hossein.bakand.ui.carlist.R.drawable.ic_price),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier,
                text = carModel.priceInformation.price.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier,
                text = carModel.priceInformation.currency,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
                painter = painterResource(hossein.bakand.ui.carlist.R.drawable.ic_year_model),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier,
                text = carModel.modelYear,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
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
            CarListScreen(uiState = CarListUiState(), {}, {}, {}, {})

        }
    }
}