plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "hossein.bakand.core.designsystem"
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }

    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(project(":core:common-ui"))
}

