plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace="hossein.bakand.mercedesbenz_task"
    compileSdk = 33

    defaultConfig {
        applicationId = "hossein.bakand.mercedesbenz_task"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":core:common-ui"))
    implementation(project(":core:common"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":ui:carlist"))
    implementation(project(":workManager"))

    implementation(Libraries.CoreKtx)
    implementation(platform(Libraries.KotlinBom))
    implementation(platform(Libraries.ComposeBom))
    implementation(Libraries.Lifecycle)

    testImplementation(TestLibraries.Junit)

    implementation(Libraries.Hilt)
    implementation(Libraries.HiltNavigation)
    kapt(Libraries.HiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}