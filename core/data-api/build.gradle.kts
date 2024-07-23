plugins {
    id("verywords.plugin.android.kotlin")
}

android {
    setNamespace("core.data.repository.api")
}

dependencies {
    implementation(projects.core.model)

}