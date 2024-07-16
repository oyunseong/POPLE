plugins {
    id("verywords.plugin.android.library")
    id("verywords.plugin.android.library.compose")
//    id("com.google.ar.sceneform.plugin")
}



android {
    namespace = "com.verywords.ar"
}

dependencies {
    // Provides ARCore Session and related resources.
    implementation("com.google.ar:core:1.44.0")
    implementation("com.google.ar.sceneform.ux:sceneform-ux:1.17.1")
    implementation("com.google.ar.sceneform:core:1.17.1")

}
//
//sceneform.asset('src/main/java/org/techtown/samplear/sampledata/model.obj',
//    'default',
//    'src/main/java/org/techtown/samplear/sampledata/model.sfa',
//    'src/main/assets/model')