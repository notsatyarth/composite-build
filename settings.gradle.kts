enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        mavenLocal()
    }
    includeBuild("plugins")
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") {
                from(files("gradle/libs.versions.toml"))
            }
        }
    }
}
rootProject.name = "composite-build"

includeBuild("sample")





