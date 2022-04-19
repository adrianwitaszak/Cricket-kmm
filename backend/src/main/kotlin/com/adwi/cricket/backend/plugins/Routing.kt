package com.adwi.cricket.backend.plugins

import com.adwi.cricket.backend.di.inject
import com.adwi.cricket.backend.routes.getUser
import com.adwi.cricket.backend.routes.login
import com.adwi.cricket.backend.routes.register
import com.adwi.cricket.backend.routes.root
import com.adwi.cricket.backend.service.AuthService
import io.ktor.server.application.*
import io.ktor.server.auth.*
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
