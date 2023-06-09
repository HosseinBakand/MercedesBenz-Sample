package hossein.bakand.core.commonui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = nero,
    secondary = gray36,
    tertiary = Color.Black,
    background = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = nero,
    secondary = gray36,
    tertiary = Color.Black,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
//    primaryContainer = Purple90,
//    onPrimaryContainer = Purple10,
//    onSecondary = Color.White,
//    secondaryContainer = Orange90,
//    onSecondaryContainer = Orange10,
//    onTertiary = Color.White,
//    tertiaryContainer = Blue90,
//    onTertiaryContainer = Blue10,
//    error = Red40,
//    onError = Color.White,
//    errorContainer = Red90,
//    onErrorContainer = Red10,
//    onBackground = DarkPurpleGray10,
//    onSurface = DarkPurpleGray10,
//    surfaceVariant = PurpleGray90,
//    onSurfaceVariant = PurpleGray30,
//    inverseSurface = DarkPurpleGray20,
//    inverseOnSurface = DarkPurpleGray95,
//    outline = PurpleGray50,
)

@Composable
fun MercedesBenzTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = getColorScheme(darkTheme = darkTheme, dynamicColor = dynamicColor)

    val backgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp,
    )

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme, LocalAbsoluteTonalElevation provides 0.dp
    ) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}

@Composable
fun getColorScheme(
    darkTheme: Boolean,
    dynamicColor: Boolean = true,
) = when {
    // Dynamic color is available on Android 12+
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> DarkColorScheme
    else -> LightColorScheme
}