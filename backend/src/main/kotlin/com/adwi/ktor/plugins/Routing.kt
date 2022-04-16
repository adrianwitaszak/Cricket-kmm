package com.adwi.ktor.plugins

import com.adwi.ktor.di.inject
import com.adwi.ktor.models.User
import com.adwi.ktor.models.UserInput
import com.adwi.repository.UserRepository
import com.adwi.service.AuthService
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    val authService by inject<AuthService>()
    val userRepository by inject<UserRepository>()

    routing {
        get("/") {
            call.respondText("Hello World! Ad")
            val response = authService.signUp(UserInput(
                email = "adwi@gmail.com",
                password = "witaszak"
            ))
            println(response?.token)
            println(response?.user)
        }
        get("/get") {
            val users = userRepository.getAll()
            println(users)
        }
        get("/insert") {
            val user = userRepository.add(User(
                id = "1",
                name = "adrian",
                email = "test@test.com",
                hashedPass = ByteArray(9)
            ))
            println(user)
        }
    }
}
