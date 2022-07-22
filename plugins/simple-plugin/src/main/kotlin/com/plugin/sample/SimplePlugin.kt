package com.plugin.sample

import org.gradle.api.Plugin
import org.gradle.api.Project

class SimplePlugin : Plugin<Project> {

  override fun apply(target: Project) {
    target.logger.lifecycle("Applied ${javaClass.name} to ${target.name}")
  }
}
