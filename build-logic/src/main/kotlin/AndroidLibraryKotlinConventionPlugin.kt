import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
                apply("verywords.plugin.hilt")
            }
            configureKotlinAndroid()
        }
    }
}