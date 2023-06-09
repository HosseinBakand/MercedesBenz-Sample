package hossein.bakand.ui.carlist.navigtion

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hossein.bakand.core.commonui.navigation.MercedesBenzNavigationDestination
import hossein.bakand.ui.carlist.CarListScreen
import hossein.bakand.ui.carlist.markets.MarketScreen

object CarListDestination : MercedesBenzNavigationDestination {
    override val route: String = "car-list"
}
object MarketDestination : MercedesBenzNavigationDestination {
    override val route: String = "market"
}

fun NavGraphBuilder.carListGraph() {
    composable(route = CarListDestination.route) {
        CarListScreen()
    }
    composable(route = MarketDestination.route) {
        MarketScreen()
    }
}
