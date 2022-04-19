package com.adwi.cricket.backend.service

import com.adwi.cricket.backend.models.User
import com.adwi.cricket.backend.models.UserInput
import com.adwi.cricket.backend.models.UserResponse
import com.adwi.cricket.backend.repository.userrepository.UserRepositoryImpl
import java.util.*

class AuthService(
    private val repository: UserRepositoryImpl,
    private val jwtConfig: JwtConfig,
) {
    fun signIn(userInput: UserInput): UserResponse? {
        val user = repository.getUserByEmail(userInput.email)
        return user?.let {
            val isVerified = jwtConfig.verifyPassword(userInput.password, user.hashedPass)
            if (!isVerified) {
                return null
            }
            val token = generateToken(user.id, user.email)
            UserResponse(token, user)
        }
    }

    fun signUp(userInput: UserInput): UserResponse? {
        val hashedPassword = jwtConfig.encryptPassword(userInput.password)
        val id = getRandomUID()
        val emailUser = repository.getUserByEmail(userInput.email)
        return if (emailUser == null) {
            val newUser = repository.add(
                User(
                    id = id,
                    email = userInput.email,
                    hashedPass = hashedPassword,
                )
            )
            val token = generateToken(newUser.id, newUser.email)
            UserResponse(token, newUser)
        } else null
    }

    private fun generateToken(userId: String, email: String) =
        jwtConfig.generateToken(JwtConfig.JwtUser(userId, email))

    private fun getRandomUID() = UUID.randomUUID().toString()
}