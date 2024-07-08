plugins {
    id("verywords.plugin.application")
    id("verywords.plugin.hilt")
}

android {
    namespace = "com.verywords.myapplication"

    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:main"))
    implementation(project(":feature:home"))
    implementation(project(":core:navigation"))
}