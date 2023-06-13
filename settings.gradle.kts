pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.partdp.ir")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.partdp.ir")
        }
    }
}
rootProject.name = "MercedesBenzTask"
include(":app")
include(":core")
include(":ui")
include(":data")
include(":domain")
include(":ui:carlist")
include(":core:model")
include(":core:common")
include(":core:common-ui")
include(":workManager")
