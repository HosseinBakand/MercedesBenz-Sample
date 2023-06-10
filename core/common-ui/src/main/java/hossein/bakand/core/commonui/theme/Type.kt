package hossein.bakand.core.commonui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hossein.bakand.core.commonui.R


val SFProFamily = FontFamily(
        Font(R.font.sf_pro_heavy, FontWeight.Bold),
        Font(R.font.sf_pro_medium, FontWeight.Medium),
        Font(R.font.sf_pro_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
        headlineLarge = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
                lineHeight = 42.sp,
        ),
        headlineMedium = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp,
                lineHeight = 34.sp,
        ),
        headlineSmall = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp,
                lineHeight = 24.sp,
        ),
        bodyLarge = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 20.sp,
        ),
        bodyMedium = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.sp,
        ),
        bodySmall = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                lineHeight = 18.sp,
        ),
        displayLarge = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
        ),
        displayMedium = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                lineHeight = 14.sp,
        ),
        displaySmall = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
        ),
        labelLarge = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 24.sp,
        ),
        labelMedium = TextStyle(
                fontFamily = SFProFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
        )
)