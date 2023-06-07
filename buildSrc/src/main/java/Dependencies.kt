object Versions {
    //plugins
    const val gradleTools = "7.1.3"
    const val kotlinSdk = "1.8.0"

    //libraries
    const val activity = "1.5.1"
    const val core = "1.10.1"
    const val compose = "1.2.1"
//    const val composeMaterial3 = "1.1.0-alpha06"
    const val composeBom = "2022.10.00"
    const val coroutines = "1.6.4"
    const val hilt = "2.46.1"
    const val hiltWork = "1.0.0"
    const val hiltNavigation = "1.0.0"
    const val lifecycle = "2.6.1"

    // TestLibraries
    const val junit = "4.13.2"
    const val mockk = "1.12.4"
    const val androidTest = "1.4.0"
}

object Plugins {
    const val GradleTools = "com.android.tools.build:gradle:${Versions.gradleTools}"
    const val Hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val KotlinSdk = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinSdk}"
    const val KotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinSdk}"
}

object Libraries {
    const val ComposeActivity = "androidx.activity:activity-compose:${Versions.activity}"
    const val ComposeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val ComposeUi = "androidx.compose.ui:ui"
    const val ComposeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val ComposeUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
    const val ComposeUiGraphic = "androidx.compose.ui:ui-graphics"
    const val ComposeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val ComposeMaterial = "androidx.compose.material3:material3"
    const val CoreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val KotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlinSdk}"
    const val Hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

}

object TestLibraries {
    const val CoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val Junit = "junit:junit:${Versions.junit}"
}
