pluginManagement {
    includeBuild("build-logic")
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

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "POPLE"
include(":app")

// Core
include(
    ":core:data",
    ":core:designsystem",
    ":core:data-api",
    ":core:datastore",
    ":core:navigation",
    ":core:model"
)

// Feature
include(
    ":feature:setting",
    ":feature:webview",
    ":feature:home",
    ":feature:main"
)
