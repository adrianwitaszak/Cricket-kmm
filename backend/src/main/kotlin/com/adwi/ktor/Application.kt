package com.adwi.ktor

import com.adwi.ktor.plugins.configureKoin
import com.adwi.ktor.plugins.configureRouting
import com.adwi.ktor.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty,  port = 8080, host = "0.0.0.0") {
        configureKoin()
        configureRouting()
//        configureSecurity()
        configureSerialization()
    }.start(wait = true)
}
