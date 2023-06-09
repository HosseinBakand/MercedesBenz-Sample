package hossein.bakand.mercedesbenz_task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import hossein.bakand.ui.carlist.navigtion.CarListDestination
import hossein.bakand.ui.carlist.navigtion.MarketDestination
import hossein.bakand.ui.carlist.navigtion.carListGraph

@Composable
fun MercedesBenzNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = MarketDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        carListGraph(navController = navController)
    }
}