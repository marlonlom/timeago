/*
 * Copyright (c) 2016, marlonlom
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(libs.kotlin.gradle.plugin)
  }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.dokka) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.spotless) apply false
}

/**
 * Spotless plugin configuration
 */
subprojects {
  apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
  configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
      target("**/*.kt")
      targetExclude("${layout.buildDirectory}/**/*.kt")
      ktlint().editorConfigOverride(
        mapOf(
          "android" to "true",
          "charset" to "utf-8",
          "end_of_line" to "lf",
          "indent_style" to "space",
          "indent_size" to 2,
          "insert_final_newline" to true,
          "max_line_length" to 120,
          "trim_trailing_whitespace" to true,
          "ij_continuation_indent_size" to 2,
          "ij_kotlin_name_count_to_use_star_import" to 999,
          "ij_kotlin_name_count_to_use_star_import_for_members" to 999,
          "ktlint_function_naming_ignore_when_annotated_with" to "Composable"
        ),
      )
      trimTrailingWhitespace()
      leadingTabsToSpaces()
      endWithNewline()
      licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
    }

    kotlinGradle {
      target("**/*.kts")
      targetExclude("**/build/**/*.kts")
      ktlint()
      trimTrailingWhitespace()
      leadingTabsToSpaces()
      endWithNewline()
      licenseHeaderFile(rootProject.file("spotless/copyright.kts"), "(^(?![\\/ ]\\*).*$)")
    }

    format("xml") {
      target("**/*.xml")
      targetExclude("**/build/**/*.xml")
      trimTrailingWhitespace()
      leadingTabsToSpaces()
      endWithNewline()
      licenseHeaderFile(rootProject.file("spotless/copyright.xml"), "(<[^!?])")
    }
  }
}

