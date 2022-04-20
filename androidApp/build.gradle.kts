import AppConfig.javaVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import AppConfig.javaVersionName

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
}

group = Group.android
version = Releases.android

android {
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
//    compileOptions {
//        sourceCompatibility = javaVersionName
//        targetCompatibility = javaVersionName
//    }
//    kotlinOptions {
//        jvmTarget = javaVersion
//    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = javaVersion
        freeCompilerArgs = listOf(
            "-Xskip-prerelease-check",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        )
    }
}

dependencies {
    implementation(project(Modules.COMMON))

    // Needed to run Compose Motion Layout Inspector
//    implementation("androidx.constraintlayout:constraintlayout-core:1.0.3")

    with(Android) {
//        implementation(coil)
//        implementation(paging)
        implementation(coreKtx)
//        implementation(appcompat)
        implementation(lifecycle)
//        implementation(accompanistInsets)
//        implementation(accompanistSwipeRefresh)
//        implementation(accompanistNavigationAnimation)
//        implementation(accompanistSystemUiController)
    }
    with(Compose) {
        implementation(composeUi)
//        implementation(composePaging)
//        implementation(composeUiUtil)
        implementation(composeTooling)
//        implementation(composeRuntime)
//        implementation(composeCompiler)
        implementation(composeActivity)
        implementation(composeMaterial)
//        implementation(composeMaterial3)
//        implementation(composeAnimation)
//        implementation(composeNavigation)
//        implementation(composeUiGraphics)
        implementation(composeFoundation)
//        implementation(composeAnimationCore)
//        implementation(composeMaterialIcons)
//        implementation(composeConstrainLayout)
//        implementation(composeFoundationLayout)
    }
}