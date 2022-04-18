package com.adwi.ktor.plugins

import com.adwi.ktor.di.Koin
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun Application.configureKoin() {

//    val secret = environment.config.propertyOrNull("SECRET")?.getString() ?: "secret"
//    val mongoUri = environment.config.propertyOrNull("MONGO_URI")?.getString() ?: ""

    install(Koin) {
        SLF4JLogger()
//        appModule(secret, mongoUri, environment.config)
        +modules
    }
}