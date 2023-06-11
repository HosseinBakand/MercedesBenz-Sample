object Versions {
    //plugins
    const val gradleTools = "7.1.3"
    const val kotlinSdk = "1.8.0"

    //libraries
    const val activity = "1.5.1"
    const val androidxLifecycle = "2.6.0-alpha05"
    const val androidxWork = "2.7.1"
    const val core = "1.10.1"
    const val compose = "1.2.1"
    const val composeMaterial3 = "1.1.0"
    const val composeBom = "2022.10.00"
    const val coroutines = "1.6.4"
    const val hilt = "2.46.1"
    const val hiltWork = "1.0.0"
    const val hiltNavigation = "1.0.0"
    const val lifecycle = "2.6.1"
    const val androidxNavigation = "2.5.3"
    const val retrofit = "2.9.0"
    const val room = "2.5.0"
    const val serialization = "1.5.0"
    const val okhttp = "4.10.0"
    const val retrofitKotlinxSerializationJson = "1.0.0"

    // TestLibraries
    const val junit = "4.13.2"
    const val mockk = "1.12.4"
    const val androidTest = "1.4.0"
}

object Plugins {
    const val GradleTools = "com.android.tools.build:gradle:${Versions.gradleTools}"
    const val Hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val KotlinSdk = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinSdk}"
    const val KotlinSerialization =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinSdk}"
}

object Libraries {
    const val AndroidxWorkKtx = "androidx.work:work-runtime-ktx:${Versions.androidxWork}"
    const val ComposeActivity = "androidx.activity:activity-compose:${Versions.activity}"
    const val ComposeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val ComposeUi = "androidx.compose.ui:ui"
    const val ComposeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val ComposeUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
    const val ComposeUiGraphic = "androidx.compose.ui:ui-graphics"
    const val ComposeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val ComposeMaterial = "androidx.compose.material3:material3"
    const val AndroidxComposeMaterial3 =
        "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val AndroidxComposeMaterial3WindowSizeClass =
        "androidx.compose.material3:material3-window-size-class:${Versions.composeMaterial3}"
    const val AndroidxLifecycleLivedataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
    const val AndroidxLifecycleRuntimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.androidxLifecycle}"
    const val AndroidxLifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidxLifecycle}"

    const val ComposeNavigation =
        "androidx.navigation:navigation-compose:${Versions.androidxNavigation}"
    const val CoreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val CoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val CoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val KotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlinSdk}"

    const val HiltExtWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
    const val Hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val HiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    const val RoomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val RoomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val RoomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val RetrofitKotlinSerialization =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinxSerializationJson}"
    const val OkhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val Serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
}

object TestLibraries {
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val Junit = "junit:junit:${Versions.junit}"
}
