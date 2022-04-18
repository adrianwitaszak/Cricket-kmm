package com.adwi.ktor.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*

fun Application.configureCallLogger() {
    install(CallLogging) {

    }
}