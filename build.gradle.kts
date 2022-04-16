buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Gradle.gradle)
        classpath(Gradle.kotlin)
        classpath(Gradle.serialization)
        classpath(Gradle.sqlDelight)
        classpath(Gradle.shadow)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}