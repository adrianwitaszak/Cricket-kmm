package com.adwi.buddy.backend.plugins

import com.adwi.buddy.backend.di.inject
import com.adwi.buddy.backend.routes.getUser
import com.adwi.buddy.backend.routes.login
import com.adwi.buddy.backend.routes.register
import com.adwi.buddy.backend.routes.root
import com.adwi.buddy.backend.service.AuthService
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