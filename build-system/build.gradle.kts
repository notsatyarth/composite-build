plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral() {
        setUrl("https://maven.google.com")

    }
    gradlePluginPortal()
    mavenCentral() {
        metadataSources {
            mavenPom()
            artifact()
        }
    }
}


//FIXME: https://youtrack.jetbrains.com/issue/KTIJ-19370 causes IDE not to recognize deps for
// autocompete
@Suppress(
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED",
    "DSL_SCOPE_VIOLATION"
)
dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.maven.settings.plugin)
}
