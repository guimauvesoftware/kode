pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // Plugins
            version("kotlin", "2.0.0")
            plugin("multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
            plugin("serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
            plugin("kover", "org.jetbrains.kotlinx.kover").version("0.8.0")
            plugin("ksp", "com.google.devtools.ksp").version("2.0.0-1.0.21")
            plugin("maven", "com.vanniktech.maven.publish").version("0.28.0")

            // Kaccelero
            version("kaccelero", "0.2.0")
            library("kaccelero-core", "dev.kaccelero", "core").versionRef("kaccelero")
        }
    }
}

rootProject.name = "kode"
include(":kode")
include(":kode-kotlin")
