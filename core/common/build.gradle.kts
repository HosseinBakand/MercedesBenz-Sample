plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "hossein.bakand.core.common"

}

dependencies {
    api(Libraries.Hilt)
    kapt(Libraries.HiltCompiler)
}