package hossein.bakand.ui.carlist

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import hossein.bakand.core.commonui.DevicePreviews
import hossein.bakand.data.model.Brand
import hossein.bakand.data.model.Market

@Composable
fun CarListScreen() {
    CarListScreen("Mercedes")
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarListScreen(title: String) {
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Search",)
                Text(text = "Filter",)
            }
            BrandsComponent(brands = emptyList())
            CarsComponent(cars = emptyList())
        }
    }
}

@Composable
fun BrandsComponent(brands: List<Brand>) {

}

@Composable
fun CarsComponent(cars: List<String>) {

}

@Composable
@DevicePreviews
fun CarListPreview() {
    CarListScreen(title = "Start")
}