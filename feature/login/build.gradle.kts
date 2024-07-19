plugins {
    id("verywords.plugin.feature")
}

android {
    setNamespace("feature.login")
}

dependencies {
    implementation(libs.googleid)
    implementation(libs.credentials)
    implementation(libs.credentials.play.services.auth)
}