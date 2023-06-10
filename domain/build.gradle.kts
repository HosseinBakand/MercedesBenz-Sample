plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "hossein.bakand.core.designsystem"

}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(Libraries.Hilt)
    kapt(Libraries.HiltCompiler)
}