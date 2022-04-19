package com.adwi.cricket.backend.plugins

import com.adwi.cricket.backend.di.inject
import com.adwi.cricket.backend.service.JwtConfig
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {

    val jwtConfig by inject<JwtConfig>()

    install(Authentication) {
        jwt {
            jwtConfig.configureKtorFeature(this)
        }
    }
}
