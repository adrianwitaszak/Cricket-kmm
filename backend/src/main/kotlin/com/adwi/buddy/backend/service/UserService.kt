package com.adwi.buddy.backend.service

import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.models.User

class UserService(
    private val userRepository: UserRepository,
) {
    fun getUserById(userId: String): User {
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