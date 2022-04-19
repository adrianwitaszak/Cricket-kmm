package com.adwi.cricket.backend.routes

import com.adwi.cricket.backend.models.UserInput
import com.adwi.cricket.backend.service.AuthService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.register(authService: AuthService) {
    post("/register") {
        val userInput = call.receive<UserInput>()
        val result = authService.signUp(userInput)

        result?.let {
            call.respond(result.token)
        } ?: run {
            call.respond(HttpStatusCode.Unauthorized, "${userInput.email} account already exists!")
            return@post
        }
    }
}