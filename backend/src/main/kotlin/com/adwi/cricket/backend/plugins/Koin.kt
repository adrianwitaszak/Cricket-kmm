package com.adwi.cricket.backend.plugins

import com.adwi.cricket.backend.di.Koin
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun Application.configureKoin() {
    install(Koin) {
        SLF4JLogger()
        +modules
    }
}