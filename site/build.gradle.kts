import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin(Plugins.KOTLIN_MULTIPLATFORM)
    id(Plugins.JETBRAINS_COMPOSE) version "1.0.1"
    id(Plugins.KOBWEB_APPLICATION) version "0.9.11"
    id(Plugins.KOBWEB_MARKDOWN) version "0.9.11"
}


group = Group.site
version = Releases.site

kobweb {
    index {
        description.set("Powered by Kobweb")
    }
}

kotlin {
    js(IR) {
        moduleName = AppConfig.module
        browser {
            commonWebpackConfig {
                outputFileName = "${AppConfig.module}.js"
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
//                implementation(project(Modules.SHARED))
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobwebx.markdown)
             }
        }
    }
}