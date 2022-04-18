package com.adwi.ktor

import com.adwi.ktor.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty,  port = 8080, host = "0.0.0.0") {
        configureKoin()
        configureRouting()
        configureSecurity()
        configureCallLogger()
        configureSerialization()
    }.start(wait = true)
}
