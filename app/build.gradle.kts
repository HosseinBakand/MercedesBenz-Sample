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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Libraries.CoreKtx)
    implementation(Libraries.ComposeActivity)
    implementation(Libraries.ComposeUi)
    implementation(Libraries.ComposeUiGraphic)
    implementation(Libraries.ComposeTooling)
    implementation(Libraries.ComposeToolingPreview)
    implementation(Libraries.ComposeMaterial)
    implementation(platform(Libraries.KotlinBom))
    implementation(platform(Libraries.ComposeBom))
    implementation(Libraries.Lifecycle)

    testImplementation(TestLibraries.Junit)

    implementation(Libraries.Hilt)
    kapt(Libraries.HiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}