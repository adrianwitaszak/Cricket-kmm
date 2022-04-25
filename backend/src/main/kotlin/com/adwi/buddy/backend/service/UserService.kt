package com.adwi.buddy.backend.service

import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.models.User

class UserService(
    private val userRepository: UserRepository,
    private val jwtConfig: JwtConfig
) {
    fun getUserById(userId: String): User {
        return userRepository.getById(userId)
    }

    fun updateUserCocktailFavorites(cocktailId: String, userId: String): Boolean {
        return updateUserById(userId) {user ->
            user.addFavorite(cocktailId)
        }
    }

    fun updateUserCredentials(userId: String, email: String, password: String): Boolean {
        val hashedPass = jwtConfig.encryptPassword(password)
        return updateUserById(userId) {user ->
            user.copy(email = email, hashedPass = hashedPass)
        }
    }

    fun updatePassword(userId: String, email: String): Boolean {
        return updateUserById(userId) {user ->
            user.copy(email = email)
        }
    }

    private fun updateUserById(userId: String, block: (User) -> User): Boolean {
        return try {
            val user = userRepository.getById(userId)
            val newUser = block(user)
            val updated = userRepository.update(newUser)
            updated == newUser
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}