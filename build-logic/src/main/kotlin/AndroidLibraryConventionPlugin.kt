@file:Suppress("unused")

import com.android.build.gradle.LibraryExtension
import convention.configureAndroidCompose
import convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-parcelize")
                apply("verywords.plugin.hilt")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                defaultConfig.targetSdk = 34

                defaultConfig {
                    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                viewBinding.enable = true

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            val libs = extensions.libs
            dependencies {
                "testImplementation"(libs.findLibrary("androidx.ui.test.junit4").get())
                "implementation"(libs.findLibrary("androidx.junit.ktx").get())
            }
        }
    }
}