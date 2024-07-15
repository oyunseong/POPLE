plugins {
    id("verywords.plugin.android.library")
    id("verywords.plugin.android.library.compose")
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.navigation")
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}