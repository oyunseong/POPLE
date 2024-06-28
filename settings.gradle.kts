pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "POPLE"
include(":app")
include(":core:data")
include(":feature:main")
include(":feature:home")
include(":core:designsystem")
include(":core:data-api")
include(":core:datastore")
include(":core:navigation")
include(":core:model")
include(":feature:setting")
include(":feature:webview")
