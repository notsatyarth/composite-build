enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        mavenLocal()
    }
    includeBuild("plugins/simple-plugin")
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}
rootProject.name = "composite-build"
include(":app")
include(":lib-a")
include(":lib-b")
include(":lib-c")
include(":network")
project(":app").projectDir = File("sample/app")
project(":lib-a").projectDir = File("sample/lib-a")
project(":lib-b").projectDir = File("sample/lib-b")
project(":lib-c").projectDir = File("sample/lib-c")






