package com.adwi.buddy.backend.plugins

import com.adwi.buddy.backend.service.AuthService
import com.adwi.buddy.backend.service.JwtConfig
import com.adwi.buddy.backend.service.UserService
import com.adwi.buddy.models.User
import com.adwi.buddy.models.UserInput
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {

    val authService: AuthService by inject(AuthService::class.java)
    val userService: UserService by inject(UserService::class.java)

    routing {
        get("/") {
            call.respondText("Hello Cricket!")
        }
        post("/login") {
            val userInput = receiveUserInput()
            val result = authService.signIn(userInput)

            result ?: run {
                call.respond(HttpStatusCode.Unauthorized, "Invalid credentials!")
                return@post
            }
            call.respond(result.token)
        }
        post("/register") {
            val userInput = receiveUserInput()
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
                val jwtUser = getCurrentUser()
                val user = userService.getUserById(jwtUser.userId)
                call.respond(user)
            }
            post("/me") {
                val jwtUser = getCurrentUser()
                val userInput = receiveUserInput()
                userService.updateUserCredentials(
                    userId = jwtUser.userId,
                    email = userInput.email,
                    password = userInput.password
                )
                call.respond("Credentials updated")
            }
            get("/me/cocktails") {

            }
        }
    }
}

private fun PipelineContext<Unit, ApplicationCall>.getCurrentUser() =
    call.authentication.principal as JwtConfig.JwtUser

private suspend fun PipelineContext<Unit, ApplicationCall>.receiveUserInput() =
    call.receive<UserInput>()
