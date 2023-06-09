plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "hossein.bakand.core.designsystem"

}

dependencies {
    implementation(project(":core:common"))

//    implementation(Libraries.Hilt)
}