package com.adwi.ktor.routes

import com.adwi.ktor.models.UserInput
import com.adwi.ktor.service.AuthService
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