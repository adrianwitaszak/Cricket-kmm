package com.adwi.cricket.backend.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.root() {
    get("/") {
        call.respondText("Hello Cricket!")
    }
}