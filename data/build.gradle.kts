plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("org.jetbrains.kotlin.plugin.serialization")
//    id("kotlin")
//    id("kotlinx-serialization")
}

android {
    namespace = "hossein.bakand.core.designsystem"

}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":domain"))

    implementation(Libraries.Retrofit)
    implementation(Libraries.OkhttpLogging)
    implementation(Libraries.RoomKtx)
    implementation(Libraries.RoomRuntime)
    implementation(Libraries.Serialization)

    kapt(Libraries.RoomCompiler)
}