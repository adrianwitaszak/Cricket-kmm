package com.adwi.buddy.backend.service

import at.favre.lib.crypto.bcrypt.BCrypt
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import java.nio.charset.StandardCharsets

class JwtConfig(jwtSecret: String) {

    companion object Constants {
        private const val jwtIssuer = "com.adwi"
        private const val jwtRealm = "com.adwi.todolist"
        private const val CLAIM_USERID = "userId"
        private const val CLAIM_USERNAME = "userName"
    }

    private val jwtAlgorithm = Algorithm.HMAC512(jwtSecret)
    private val jwtVerifier: JWTVerifier = JWT
        .require(jwtAlgorithm)
        .withIssuer(jwtIssuer)
        .build()

    fun generateToken(user: JwtUser): String = JWT.create()
        .withSubject("Authentication")
        .withIssuer(jwtIssuer)
        .withClaim(CLAIM_USERID, user.userId)
        .withClaim(CLAIM_USERNAME, user.userName)
        .sign(jwtAlgorithm)

    fun configureKtorFeature(config: JWTAuthenticationProvider.Config) = with(config) {
        verifier(jwtVerifier)
        realm = jwtRealm
        validate {
            val userId = it.payload.getClaim(CLAIM_USERID).asString()
            val userName = it.payload.getClaim(CLAIM_USERNAME).asString()

            if (userId != null && userName != null) {
                JwtUser(userId, userName)
            } else {
                null
            }
        }
        challenge { _, _ ->
            call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
        }
    }

    fun verifyPassword(inputPassword: String, hashedPassword: ByteArray): Boolean = BCrypt.verifyer()
        .verify(
            inputPassword.toByteArray(Charsets.UTF_8),
            hashedPassword
        ).verified

    fun encryptPassword(password: String): ByteArray =
        BCrypt.withDefaults().hash(10, password.toByteArray(StandardCharsets.UTF_8))

    @Serializable
    data class JwtUser(val userId: String, val userName: String): Principal
}