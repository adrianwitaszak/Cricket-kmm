package com.adwi.ktor.plugins

import com.adwi.ktor.di.inject
import com.adwi.ktor.routes.getUser
import com.adwi.ktor.routes.login
import com.adwi.ktor.routes.register
import com.adwi.ktor.routes.root
import com.adwi.ktor.service.AuthService
import com.adwi.ktor.service.JwtConfig
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val authService by inject<AuthService>()

    routing {
        root()
        login(authService)
        register(authService)

        authenticate {
            getUser()
        }
    }
}
