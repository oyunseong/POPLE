package convention

import com.android.build.api.dsl.CommonExtension
import libs
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// AndroidCompose.kt
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    with(plugins) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    val libs = extensions.libs

    commonExtension.apply {
        buildFeatures.compose = true
    }

    dependencies {
        "implementation"(platform(libs.findLibrary("androidx.compose.bom").get()))
        "androidTestImplementation"(platform(libs.findLibrary("androidx.compose.bom").get()))
        "implementation"(libs.findLibrary("androidx.activity.compose").get())
        "implementation"(libs.findLibrary("androidx.ui").get())
        "implementation"(libs.findLibrary("androidx.ui.graphics").get())
        "implementation"(libs.findLibrary("androidx.compose.ui.tooling.preview").get())
        "implementation"(libs.findLibrary("androidx.material3").get())

        "debugImplementation"(libs.findLibrary("androidx.compose.ui.tooling").get())
        "debugImplementation"(libs.findLibrary("androidx.ui.test.manifest").get())

        "implementation"(libs.findLibrary("hilt.navigation.compose").get())
        "implementation"(libs.findLibrary("androidx.compose.navigation").get())
        "implementation"(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
        "implementation"(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

        "implementation"(libs.findLibrary("kotlinx.immutable").get())
    }
}
