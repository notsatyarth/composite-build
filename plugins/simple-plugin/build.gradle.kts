import java.net.URI

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    jacoco
    id("maven-publish")
}

repositories {
    google()
    mavenCentral() {
        setUrl("https://maven.google.com")

    }
    maven(url = "https://jitpack.io")
    gradlePluginPortal()
    mavenCentral() {
        metadataSources {
            mavenPom()
            artifact()
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs(
        "-XX:+HeapDumpOnOutOfMemoryError", "-XX:GCTimeLimit=20", "-XX:GCHeapFreeLimit=10",
        "-XX:MaxMetaspaceSize=1g"
    )
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
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
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.maven.settings.plugin)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.api)
    testImplementation(libs.junit)
    testImplementation(libs.junit.params)
    testImplementation(libs.truth)
    testRuntimeOnly(libs.junit.engine)
}

group = "com.sample.plugin"
version = "0.0.1"
gradlePlugin {
    plugins.create("sample-plugin") {
        id = "com.plugin.sample"
        implementationClass = "com.plugin.sample.SimplePlugin"
        displayName = "Simple Plugin that does nothing but only consumes CPU cycles!"

    }
}
