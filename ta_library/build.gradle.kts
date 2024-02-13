import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id("java-library")
  alias(libs.plugins.kotlin.jvm)
  id("org.jetbrains.dokka")
  id("maven-publish")
}

version = "4.0.3"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17

  withSourcesJar()

  archivesName = rootProject.name
}

tasks.withType<Jar> {
  manifest {
    attributes["Main-Class"] = "com.github.marlonlom.utilities.timeago.TimeAgo"
    attributes["Package"] = "com.github.marlonlom.utilities.timeago"
    attributes["Created-By"] = "marlonlom"
  }
}

dependencies {
  testImplementation(libs.junit)
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
  dependsOn(tasks.dokkaJavadoc)
  from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
  archiveClassifier.set("javadoc")
}

artifacts {
  add("archives", dokkaJavadocJar)
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = "com.github.marlonlom"
      artifactId = "timeago"
      version = "4.0.3"

      from(components["java"])
      archivesName = rootProject.name

      pom {
        artifactId = "timeago"
        name = "Timeago"
        description = "Simple java library for displaying dates as relative time ago language."
        url = "https://github.com/marlonlom/timeago"
        packaging = "jar"

        licenses {
          license {
            name = "The Apache License, Version 2.0"
            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            distribution = "repo"
            comments = "A business-friendly OSS license"
          }
        }

        developers {
          developer {
            id = "marlonlom"
            name = "Marlon López"
            email = "malm.gm@gmail.com"
          }
        }

        scm {
          connection = "git@github.com:marlonlom/timeago.git"
          developerConnection = "git@github.com:marlonlom/timeago.git"
          url = "https://github.com/marlonlom/timeago"
        }
      }

    }
  }
}
