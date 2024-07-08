plugins {
    id("verywords.plugin.feature")
}

android {
    setNamespace("feature.main")
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.setting)
    implementation(projects.feature.webview)
}