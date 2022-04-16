package com.adwi.plugins

import com.adwi.di.inject
import com.adwi.models.User
import com.adwi.models.UserInput
import com.adwi.repository.UserRepository
import com.adwi.service.AuthService
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    val authService by inject<AuthService>()
    val userRepository by inject<UserRepository>()

    routing {
        get("/") {
            call.respondText("Hello World!")
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
