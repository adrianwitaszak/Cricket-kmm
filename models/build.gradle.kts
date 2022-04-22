plugins {
    java
    kotlin(Plugins.JVM)
    kotlin(Plugins.SERIALIZATION)
}

java {
    sourceCompatibility = AppConfig.javaVersionName
    targetCompatibility = AppConfig.javaVersionName
}