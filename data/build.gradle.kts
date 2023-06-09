plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("org.jetbrains.kotlin.plugin.serialization")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "hossein.bakand.data"

}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":domain"))

    implementation(Libraries.Retrofit)
    implementation(Libraries.RetrofitKotlinSerialization)
    implementation(Libraries.OkhttpLogging)
    implementation(Libraries.RoomKtx)
    implementation(Libraries.RoomRuntime)
    implementation(Libraries.Serialization)
    kapt(Libraries.RoomCompiler)

    implementation(Libraries.Hilt)
    kapt(Libraries.HiltCompiler)
}