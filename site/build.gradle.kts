import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.0.1"
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}


group = "com.adwi"
version = "1.0-SNAPSHOT"

kobweb {
    index {
        description.set("Powered by Kobweb")
    }
}

kotlin {
    jvm {
        tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "11"
        }
        tasks.named("jvmJar", Jar::class.java).configure {
            archiveFileName.set("morple.jar")
        }
    }
    js(IR) {
        moduleName = "site"
        browser {
            commonWebpackConfig {
                outputFileName = "site.js"
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobwebx.markdown)
             }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)
             }
        }
    }
}