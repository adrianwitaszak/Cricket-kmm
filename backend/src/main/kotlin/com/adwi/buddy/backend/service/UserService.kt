package com.adwi.buddy.backend.service

import com.adwi.buddy.models.User
import com.adwi.buddy.backend.repository.UserRepositoryImpl

class UserService(
    private val userRepository: UserRepositoryImpl,
) {
    fun getUser(userId: String): User {
        return userRepository.getById(userId)
    }

    fun updateUserCocktailFavorites(cocktailId: String, userId: String): Boolean {
        return try {
            val user = userRepository.getById(userId)
            val updatedUser = user.addFavorite(cocktailId)
            val updatedRemoteUser = userRepository.update(updatedUser)
            updatedRemoteUser == updatedUser
        } catch (e: Exception) {
            println(e)
            false
        }
    }
}