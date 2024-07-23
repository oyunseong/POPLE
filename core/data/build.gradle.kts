plugins {
    id("verywords.plugin.android.kotlin")
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.datastore)
    implementation(projects.core.dataApi)
    implementation(projects.core.model)


    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}