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
    implementation(projects.feature.map)
    implementation(projects.feature.login)
}