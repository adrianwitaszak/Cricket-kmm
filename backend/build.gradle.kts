plugins {
    application
    kotlin(Plugins.JVM)
    kotlin(Plugins.SERIALIZATION)
    id(Plugins.SHADOW)
}


group = "com.adwi.ktor"
version = "0.0.1"

application {
    mainClass.set("com.adwi.ktor.ApplicationKt")

    applicationDefaultJvmArgs = listOf(
        "-Dio.ktor.development=true",
        "-Djdk.tls.client.protocols=TLSv1.2"
    )
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = AppConfig.javaVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = AppConfig.javaVersion
    }
}

dependencies {
    with(Ktor) {
        implementation(kMongo)
        implementation(bCrypt)
    }
    with(Ktor.Server) {
        implementation(core)
        implementation(netty)
        implementation(json)
        implementation(auth)
        implementation(jwt)
        implementation(contentNegotiation)
        implementation(logback)
        implementation(test)
    }
    with(Koin) {
        implementation(ktor)
        implementation(logger)
    }
    with(Kotlin) {
        implementation(stdlib)
    }
}