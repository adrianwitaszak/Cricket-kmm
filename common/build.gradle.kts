import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    with(Plugins) {
        kotlin(KOTLIN_MULTIPLATFORM)
        kotlin(COCAPODS)
//        id(JETBRAINS_COMPOSE) version Compose.jetbrainsComposeVersion
        id(ANDROID_LIBRARY)
        id(SQL_DELIGHT)
        id(SHADOW)
    }
}

version = "1.0"

android {
    compileSdk = AppConfig.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersionName
        targetCompatibility = AppConfig.javaVersionName
    }
}

kotlin {
    android()
    jvm()
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()
//
//    cocoapods {
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        ios.deploymentTarget = "14.1"
//        podfile = project.file("../iosApp/Podfile")
//        framework {
//            baseName = "common"
//        }
//    }

    sourceSets {
        sourceSets["commonMain"].dependencies {
            with(Kotlin) {
                implementation(coroutinesCore)
                api(kermitLogger)
                implementation(serializationJson)
            }
            with(Koin) {
                api(core)
                api(logger)
                api(test)
            }
            implementation(Ktor.Client.clientCore)
            implementation(SqlDelight.coroutineExtensions)
        }
        sourceSets["androidMain"].dependencies {
            implementation(Ktor.Client.clientOkHttp)
            implementation(SqlDelight.androidDriver)
        }
        sourceSets["jsMain"].dependencies {
            implementation(Ktor.Client.clientJs)
            implementation(SqlDelight.sqliteJs)
        }
        sourceSets["jvmMain"].dependencies {

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidTest by getting
        val jsTest by getting

//        val iosX64Main by getting
//        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependsOn(commonMain)
//            dependencies {
//                implementation(Ktor.Client.clientIOS)
//                implementation(SqlDelight.nativeDriver)
//            }
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
//        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
//        }
    }
}

sqldelight {
    database("buddy") {
        packageName = AppConfig.applicationId
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = AppConfig.javaVersion
    }
}