plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "hossein.bakand.ui.carlist"
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }

    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(project(":core:common-ui"))
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":domain"))


    implementation(Libraries.Hilt)
    kapt(Libraries.HiltCompiler)
}

