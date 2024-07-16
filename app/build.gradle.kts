plugins {
    id("verywords.plugin.application")
}

android {
    namespace = "com.verywords.app"

    defaultConfig {
        targetSdk = Constants.TARGET_SDK
        versionCode = Constants.VERSION_CODE
        versionName = Constants.VERSION_NAME
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