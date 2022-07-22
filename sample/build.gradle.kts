@file:Suppress(
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED",
    "DSL_SCOPE_VIOLATION"
)

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    jacoco
    id("com.plugin.sample") apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
}