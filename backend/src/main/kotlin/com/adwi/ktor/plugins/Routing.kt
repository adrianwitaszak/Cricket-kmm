package com.adwi.ktor.plugins

import com.adwi.ktor.di.inject
import com.adwi.ktor.models.UserInput
import com.adwi.ktor.service.AuthService
import com.adwi.ktor.service.JwtConfig
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val authService by inject<AuthService>()

    routing {
        get("/") {
            call.respondText("Hello Cricket!")
        }

        post("/login") {
            val userInput = call.receive<UserInput>()
            val result = authService.signIn(userInput)

            result ?: run {
                call.respond(HttpStatusCode.Unauthorized, "Invalid credentials!")
                return@post
            }
            call.respond(result.token)
        }

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

        authenticate {
            get("/me") {
                val user = call.authentication.principal as JwtConfig.JwtUser
                call.respond(user)
            }
        }
    }
}
