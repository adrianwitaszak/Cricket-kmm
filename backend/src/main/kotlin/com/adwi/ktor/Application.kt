package com.adwi

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.adwi.plugins.*

fun main(args: Array<String>) {
    embeddedServer(Netty,  port = 8080, host = "0.0.0.0") {
        configureKoin()
        configureRouting()
//        configureSecurity()
        configureSerialization()
    }.start(wait = true)
}
