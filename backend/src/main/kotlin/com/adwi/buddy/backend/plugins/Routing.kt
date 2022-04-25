package com.adwi.buddy.backend.plugins

import com.adwi.buddy.backend.service.AuthService
import com.adwi.buddy.backend.service.CocktailService
import com.adwi.buddy.backend.service.JwtConfig
import com.adwi.buddy.backend.service.UserService
import com.adwi.buddy.models.CocktailInput
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
    val cocktailService: CocktailService by inject(CocktailService::class.java)

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
                withCurrentUser { jwtUser ->
                    val user = userService.getUserById(jwtUser.userId)
                    call.respond(user)
                }
            }
            post("/me") {
                withCurrentUser { jwtUser ->
                    val userInput = receiveUserInput()
                    val result = userService.updateUserCredentials(
                        userId = jwtUser.userId,
                        email = userInput.email,
                        password = userInput.password
                    )
                    println(result)
                    call.respond("Credentials updated")
                }
            }
            get("/me/cocktails") {
                withCurrentUser { jwtUser ->
                    val user = userService.getUserById(jwtUser.userId)
                    val cocktails = cocktailService.getUserFavoriteCocktails(user)
                    call.respond(cocktails)
                }
            }
            post("/me/cocktails") {
                withCurrentUser { jwtUser ->
                    val userInput = call.receive<CocktailInput>()
                    val result = userService.addCocktailToFavorites(jwtUser.userId, userInput.id)
                    println(result)
                    call.respond("Added ${userInput.id}")
                }
            }
            delete("/me/cocktails") {
                withCurrentUser { jwtUser ->
                    val userInput = call.receive<CocktailInput>()
                    val result = userService.removeCocktailFromFavorites(jwtUser.userId, userInput.id)
                    println(result)
                    call.respond("Deleted ${userInput.id}")
                }
            }
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.withCurrentUser(block: suspend (JwtConfig.JwtUser) -> Unit) {
    val jwtUser = call.authentication.principal as JwtConfig.JwtUser
    block(jwtUser)
}

private suspend fun PipelineContext<Unit, ApplicationCall>.receiveUserInput() =
    call.receive<UserInput>()
