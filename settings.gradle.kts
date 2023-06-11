pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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
