import com.android.build.api.attributes.BuildTypeAttr

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.plugin.sample")
}

/**
 * android-library-publish consumes from the android dsl below to identify variants to publish and
 * and the version details to use
 */
android {
    compileSdkVersion(32)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
//        versionCode = 1
//        versionName = "1.0"
    }

    namespace = "com.sample.libc"
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
      
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}





dependencies {
    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.android.gradle.plugin)
    implementation(project(":lib-a"))
    implementation(project(":lib-b"))
}
