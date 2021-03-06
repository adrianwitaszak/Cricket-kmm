package com.adwi.buddy.backend

import com.adwi.buddy.backend.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty,  port = 8080, host = "0.0.0.0") {
        initKoin()
        configureRouting()
        configureSecurity()
        configureCallLogger()
        configureSerialization()
    }.start(wait = true)
}
