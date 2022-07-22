package com.sample.buildsystem

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPom


/**
 * syntactical sugar to access the publish extension from a project.
 */
@Suppress("UnstableApiUsage")
fun org.gradle.api.Project.publishing(configure: org.gradle.api.Action<org.gradle.api.publish.PublishingExtension>) {
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("publishing", configure)
}




/**
 * Sugar syntax to fetch the android extension from a project
 */
val Project.androidExtension
    get() =
        this.extensions.getByName("android") as com.android.build.gradle.LibraryExtension


