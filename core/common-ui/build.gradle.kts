plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "hossein.bakand.core.commonui"

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    api(Libraries.HiltNavigation)

    api(Libraries.ComposeActivity)
    api(Libraries.ComposeUi)
    api(Libraries.ComposeUiGraphic)
    api(Libraries.ComposeTooling)
    api(Libraries.ComposeToolingPreview)
    api(Libraries.ComposeMaterial)
    api(Libraries.ComposeNavigation)
    api(Libraries.AndroidxComposeMaterial3)
    api(Libraries.AndroidxComposeMaterial3WindowSizeClass)

//    kapt(Libraries.ComposeNavigation)
//    api("androidx.compose.material3:material3")
}
