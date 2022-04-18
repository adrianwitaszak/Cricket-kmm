package com.adwi.ktor.plugins

import com.adwi.ktor.di.inject
import com.adwi.ktor.models.UserInput
import com.adwi.ktor.service.AuthService
import com.adwi.ktor.service.JwtConfig
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureSecurity() {

    val jwtConfig by inject<JwtConfig>()

    install(Authentication) {
        jwt {
            jwtConfig.configureKtorFeature(this)
        }
    }
}
