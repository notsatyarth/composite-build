plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

/**
 * android-library-publish consumes from the android dsl below to identify variants to publish and
 * and the version details to use
 */
android {

    compileSdk = 32
    defaultConfig {
        applicationId = "com.sample.build"
        minSdk = 21

        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

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
    implementation(libs.converter.gson)
    implementation(project(":lib-c"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.espresso.core)
}
