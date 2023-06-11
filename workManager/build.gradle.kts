plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "hossein.bakand.workmanager"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":domain"))

    implementation(Libraries.Hilt)
    implementation(Libraries.HiltExtWork)
    implementation(Libraries.AndroidxWorkKtx)
    implementation(Libraries.AndroidxLifecycleLivedataKtx)
    kapt(Libraries.HiltCompiler)
}