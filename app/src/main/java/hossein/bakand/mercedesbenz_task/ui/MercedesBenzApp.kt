package hossein.bakand.mercedesbenz_task.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import hossein.bakand.core.commonui.component.MercedesBenzBackground
import hossein.bakand.core.commonui.theme.MercedesBenzTheme
import hossein.bakand.mercedesbenz_task.navigation.MercedesBenzNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MercedesBenzApp() {
    MercedesBenzTheme {
        MercedesBenzBackground() {
            Scaffold(
                modifier = Modifier
                    .navigationBarsPadding(),
            ) {
                MercedesBenzNavHost(
                    navController = rememberNavController()
                )
            }
        }
    }

}