plugins {
    application
    kotlin(Plugins.JVM)
    kotlin(Plugins.SERIALIZATION)
    id(Plugins.SHADOW)
}


group = Group.backend
version = Releases.backend

application {
    mainClass.set("${Group.backend}.ApplicationKt")

    applicationDefaultJvmArgs = listOf(
        "-Dio.ktor.development=true",
        "-Djdk.tls.client.protocols=TLSv1.2",
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
    implementation(project(Modules.COMMON))
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
        implementation(callLogging)
        implementation(contentNegotiation)
        implementation(logback)
    }
    with(Kotlin) {
//        implementation(stdlib)
    }

//    with(TestDependencies) {
//        testImplementation(kotlinTest)
//        testImplementation(ktorTest)
//        testImplementation(mockk)
//        testImplementation(koinTestJUnit4)
//    }
}