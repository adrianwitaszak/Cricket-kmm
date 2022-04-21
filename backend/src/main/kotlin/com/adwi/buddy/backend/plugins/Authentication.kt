package com.adwi.buddy.backend.plugins

import com.adwi.buddy.backend.service.JwtConfig
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureSecurity() {

    val jwtConfig by inject<JwtConfig>(JwtConfig::class.java)

    install(Authentication) {
        jwt {
            jwtConfig.configureKtorFeature(this)
        }
    }
}
