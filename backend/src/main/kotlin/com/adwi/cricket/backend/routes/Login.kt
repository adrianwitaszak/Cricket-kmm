package com.adwi.cricket.backend.routes

import com.adwi.cricket.backend.models.UserInput
import com.adwi.cricket.backend.service.AuthService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.login(authService: AuthService) {
    post("/login") {
        val userInput = call.receive<UserInput>()
        val result = authService.signIn(userInput)

        result ?: run {
            call.respond(HttpStatusCode.Unauthorized, "Invalid credentials!")
            return@post
        }
        call.respond(result.token)
    }
}