plugins {
    id("verywords.plugin.feature")
}

android {
    setNamespace("feature.webview")
}

dependencies {
    implementation(libs.accompanist.webview)
}