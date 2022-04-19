package com.adwi.cricket.backend.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import org.slf4j.event.Level

fun Application.configureCallLogger() {
    install(CallLogging) {
        level = Level.INFO
    }
}