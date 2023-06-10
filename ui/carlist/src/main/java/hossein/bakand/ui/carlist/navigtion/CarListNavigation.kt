package hossein.bakand.ui.carlist.navigtion

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import hossein.bakand.core.commonui.navigation.MercedesBenzNavigationDestination
import hossein.bakand.ui.carlist.models.CarListScreen
import hossein.bakand.ui.carlist.markets.MarketScreen

object CarListDestination : MercedesBenzNavigationDestination {
    const val marketIdArg = "chapterId"

    override val route: String = "car-list/{$marketIdArg}"

    fun createNavigationRoute(marketIdArg: String): String {
        return "car-list/$marketIdArg"
    }
}

object MarketDestination : MercedesBenzNavigationDestination {
    override val route: String = "market"
}

fun NavGraphBuilder.carListGraph(navController: NavController) {
    composable(route = CarListDestination.route,
        arguments = listOf(
            navArgument(CarListDestination.marketIdArg) { type = NavType.StringType }
        )
    ) {
        CarListScreen(){

        }
    }
    composable(route = MarketDestination.route) {
        MarketScreen(
            onMarketClick = {
                navController.navigate(CarListDestination.createNavigationRoute(it))
            }
        )
    }
}
