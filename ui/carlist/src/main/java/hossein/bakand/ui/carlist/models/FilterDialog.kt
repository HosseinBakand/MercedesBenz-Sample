package hossein.bakand.ui.carlist.models

import android.util.Range
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.util.toRange
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import hossein.bakand.core.commonui.theme.MercedesBenzTheme
import hossein.bakand.data.model.VehicleBody
import hossein.bakand.data.model.vehicleBodyPreview

@Composable
fun FilterDialog(
    onDismiss: () -> Unit,
    viewModel: CarListViewModel = hiltViewModel(),
) {
    val filterState by viewModel.filterState.collectAsStateWithLifecycle()
    SettingsDialog(
        filterState = filterState,
        onDismiss = onDismiss,
        onPriceRangeChange = viewModel::changePriceRangeFilter,
        onToggleBrandEnable = viewModel::changeBrandFilter,
        onToggleBodyEnable = viewModel::changeBodyFilter
    )
}

@Composable
fun SettingsDialog(
    filterState: FilterState,
    onDismiss: () -> Unit,
    onPriceRangeChange: (Range<Float>) -> Unit,
    onToggleBrandEnable: (String) -> Unit,
    onToggleBodyEnable: (String) -> Unit,
) {
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        ),
        onDismissRequest = { onDismiss() },
    ) {
        Column(
            Modifier
                .fillMaxWidth(0.9f)
                .verticalScroll(rememberScrollState())
                .clip(shape = MaterialTheme.shapes.large)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Filter",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            CarBrandComponent(filterState.brands, onItemClick = onToggleBrandEnable)

            Spacer(modifier = Modifier.height(8.dp))
            BodyTypeComponent(filterState.bodies, onItemClick = onToggleBodyEnable)
            Spacer(modifier = Modifier.height(8.dp))
            PriceRangeComponent(
                filterState.priceRange,
                filterState.selectedPriceRange,
                onRangeChanged = onPriceRangeChange
            )
            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "OK",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(shape = MaterialTheme.shapes.large)
                        .align(Alignment.CenterEnd)
                        .clickable { onDismiss() }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun PriceRangeComponent(
    priceRange: Range<Float>,
    selectedPriceRange: Range<Float>,
    onRangeChanged: (Range<Float>) -> Unit
) {
    Text(text = "Price Range")
    var sliderPosition by remember { mutableStateOf(selectedPriceRange.lower..selectedPriceRange.upper) }

    RangeSlider(
        modifier = Modifier
            .fillMaxWidth(),
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = priceRange.lower..priceRange.upper,
        onValueChangeFinished = {
            onRangeChanged(sliderPosition.toRange())
        }
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = sliderPosition.start.toString())
        Text(text = sliderPosition.endInclusive.toString())
    }
}

@Composable
fun BodyTypeComponent(bodies: List<Pair<VehicleBody, Boolean>>, onItemClick: (String) -> Unit) {
    Text(text = "Body Type")
    SelectableFlowRow(
        bodies.toList().map { it.first.bodyName to it.second },
        onItemClick = onItemClick
    )
}

@Composable
fun CarBrandComponent(brands: List<Pair<String, Boolean>>, onItemClick: (String) -> Unit) {
    Text(text = "Car Brands")
    SelectableFlowRow(brands.toList(), onItemClick = onItemClick)
}

@Composable
fun SelectableFlowRow(items: List<Pair<String, Boolean>>, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items.forEachIndexed { inx, word ->
            SelectableItem(
                text = word.first,
                isSelected = word.second,
                onClick = {
                    onItemClick(word.first)
                },
            )
        }
    }
}

private val SwitchAnimation = tween<Color>(300)

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val isClickable = true
    val textColor by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.onPrimary
        } else {
            MaterialTheme.colorScheme.primary
        },
        animationSpec = SwitchAnimation
    )
    val borderColor by animateColorAsState(
        targetValue = MaterialTheme.colorScheme.primary,
        animationSpec = SwitchAnimation
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.background
        },
        animationSpec = SwitchAnimation
    )

    Box(
        modifier = modifier.then(
            Modifier
                .heightIn(min = 36.dp)
                .background(backgroundColor, MaterialTheme.shapes.large)
                .border(1.dp, borderColor, MaterialTheme.shapes.large)
                .clip(MaterialTheme.shapes.large)
                .clickable(
                    enabled = onClick != null && isClickable,
                    onClick = { onClick?.invoke() })
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ), contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = text,
            style =
            MaterialTheme.typography.bodyMedium,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PreviewSettingsDialog() {
    MercedesBenzTheme {
//        Column(modifier = Modifier.background(color = Color.Cyan)) {
//            PriceRangeComponent(Range(0f, 1f), Range(0f, 1f)) {}
//        }
        SettingsDialog(
            onDismiss = {},
            filterState = FilterState(
                priceRange = Range(100f, 1000f),
                selectedPriceRange = Range(100f, 1000f),
                brands = listOf("A", "B", "C", "D").map { it to (it == "A" || it == "C") },
                bodies = vehicleBodyPreview.map { it to (it.bodyID == "1" || it.bodyID == "3") }

            ),
            onPriceRangeChange = {},
            onToggleBodyEnable = {},
            onToggleBrandEnable = {}
        )
    }
}
