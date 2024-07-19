import com.android.build.api.dsl.ApplicationExtension
import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("verywords.plugin.hilt")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
            }
            val libs = extensions.libs
            dependencies {
//                ("com.google.android.gms:play-services-auth:21.2.0")


                "testImplementation"(libs.findLibrary("androidx.ui.test.junit4").get())
            }
        }
    }
}
