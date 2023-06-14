// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.20" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.partdp.ir")
        }
    }

    dependencies {
        classpath(Plugins.GradleTools)
        classpath(Plugins.Hilt)
        classpath(Plugins.KotlinSdk)
        classpath(Plugins.KotlinSerialization)
    }
}

subprojects {

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    plugins.whenPluginAdded {
        if (this is com.android.build.gradle.AppPlugin || this is com.android.build.gradle.LibraryPlugin) {
            extensions.getByType(com.android.build.gradle.BaseExtension::class).apply {
                compileSdkVersion(BuildVersions.compileSdk)
                buildToolsVersion(BuildVersions.buildTools)
                buildFeatures.buildConfig = true
                defaultConfig {
                    minSdk = BuildVersions.minSdk
                    targetSdk = BuildVersions.targetSdk

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                    buildConfigField("long", "VERSION_CODE", "${BuildVersions.versionCode}")
                    buildConfigField("String", "VERSION_NAME", "\"${BuildVersions.versionName}\"")
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
