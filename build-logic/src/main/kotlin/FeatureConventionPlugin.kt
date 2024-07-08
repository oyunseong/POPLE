@file:Suppress("unused")

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("verywords.plugin.android.library")
                apply("verywords.plugin.android.library.compose")
                apply("verywords.plugin.hilt")
            }

            val libs = extensions.libs
            dependencies {
                // core 모듈 추가
                "implementation"(project(":core:designsystem"))
                "implementation"(project(":core:navigation"))

                "implementation"(libs.findLibrary("androidx.appcompat").get())
                "implementation"(libs.findLibrary("androidx.core.ktx").get())
                "implementation"(libs.findLibrary("androidx.navigation.ui.ktx").get())
                "implementation"(libs.findLibrary("material").get())
                "implementation"(libs.findLibrary("androidx.core.ktx").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
                "implementation"(libs.findLibrary("androidx.appcompat").get())
                "implementation"(libs.findLibrary("androidx.activity.compose").get())
                "implementation"(libs.findLibrary("androidx.appcompat").get())
            }
        }
    }
}