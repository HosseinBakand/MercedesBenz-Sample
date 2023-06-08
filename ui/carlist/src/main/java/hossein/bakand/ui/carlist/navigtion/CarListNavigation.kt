package hossein.bakand.ui.carlist.navigtion

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hossein.bakand.core.commonui.navigation.MercedesBenzNavigationDestination
import hossein.bakand.ui.carlist.CarListScreen

object CarListDestination : MercedesBenzNavigationDestination {
    override val route: String = "car-list"
}

fun NavGraphBuilder.carListGraph() {
    composable(route = CarListDestination.route) {
        CarListScreen()
    }
}
