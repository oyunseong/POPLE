plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        // App
        register("AndroidApplicationPlugin") {
            id = "verywords.plugin.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        // hilt
        register("AndroidHiltPlugin") {
            id = "verywords.plugin.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        // Android Library
        register("AndroidLibraryPlugin") {
            id = "verywords.plugin.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        // Android Compose
        register("AndroidLibraryComposePlugin") {
            id = "verywords.plugin.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        // Feature Module
        register("FeaturePlugin") {
            id = "verywords.plugin.feature"
            implementationClass = "FeatureConventionPlugin"
        }
    }
}