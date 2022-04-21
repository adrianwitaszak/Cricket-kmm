package com.adwi.buddy.backend.plugins

import com.adwi.buddy.backend.di.backendModule
import com.adwi.buddy.di.initKoin
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun Application.initKoin() {
    initKoin(true) {
        SLF4JLogger()
        modules(backendModule)
    }
}