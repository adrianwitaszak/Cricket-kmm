plugins {
    with(Plugins) {
        kotlin(KOTLIN_MULTIPLATFORM)
        kotlin(COCAPODS)
        id(JETBRAINS_COMPOSE) version Compose.jetbrainsComposeVersion
        id(ANDROID_LIBRARY)
        id(SQL_DELIGHT)
        id(SHADOW)
    }
}

version = "1.0"

kotlin {
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
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                with(Kotlin) {
                    implementation(coroutinesCore)
                    implementation(kermitLogger)
                    implementation(serializationJson)
                }
                implementation(Ktor.Client.clientCore)
                implementation(SqlDelight.coroutineExtensions)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Ktor.Client.clientOkHttp)
                implementation(SqlDelight.androidDriver)
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(Ktor.Client.clientJs)
                implementation(SqlDelight.sqliteJs)
            }
        }
        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(Ktor.Client.clientIOS)
                implementation(SqlDelight.nativeDriver)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        /* Main hierarchy */
        iosX64Main.dependsOn(iosMain)
        iosArm64Main.dependsOn(iosMain)
        iosSimulatorArm64Main.dependsOn(iosMain)

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidTest by getting
        val jsTest by getting
        val iosTest by creating
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting

        /* Test hierarchy */
        jsTest.dependsOn(commonTest)
        iosTest.dependsOn(commonTest)
        iosX64Test.dependsOn(iosTest)
        iosArm64Test.dependsOn(iosTest)
        iosSimulatorArm64Test.dependsOn(iosTest)
    }
}

android {
    compileSdk = AppConfig.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}