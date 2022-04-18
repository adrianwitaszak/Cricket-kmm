package com.adwi.ktor.routes

import com.adwi.ktor.service.JwtConfig
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUser() {
    get("/me") {
        val user = call.authentication.principal as JwtConfig.JwtUser
        call.respond(user)
    }
}