plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    jacoco
    id("com.plugin.sample") apply false
    alias(libs.plugins.android.application) apply false
}