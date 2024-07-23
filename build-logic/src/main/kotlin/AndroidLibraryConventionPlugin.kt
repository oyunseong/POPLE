@file:Suppress("unused")

import com.android.build.gradle.LibraryExtension
import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
                apply("verywords.plugin.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                viewBinding.enable = true
                dataBinding.enable = true
            }

            val libs = extensions.libs
            dependencies {
                "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
//                "testImplementation"(libs.findLibrary("androidx.ui.test.junit4").get())
//                "implementation"(libs.findLibrary("androidx.junit.ktx").get())
            }
            configureKotlinAndroid()
        }
    }
}