import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("verywords.plugin.hilt")
            }

            configureKotlinAndroid()

            val libs = extensions.libs
            dependencies {
                "testImplementation"(libs.findLibrary("androidx.ui.test.junit4").get())
            }
        }
    }
}
