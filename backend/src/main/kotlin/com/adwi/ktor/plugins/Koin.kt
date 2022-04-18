package com.adwi.ktor.plugins

import com.adwi.ktor.di.Koin
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun Application.configureKoin() {
    install(Koin) {
        SLF4JLogger()
        +modules
    }
}