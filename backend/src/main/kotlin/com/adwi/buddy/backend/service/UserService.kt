package com.adwi.buddy.backend.service

import com.adwi.buddy.backend.models.User
import com.adwi.buddy.backend.repository.UserRepository

class UserService(
    private val userRepository: UserRepository,
) {
    fun getUser(userId: String): User {
        return userRepository.getById(userId)
    }

    fun addCocktailToFavorites(cocktailId: String, userId: String): Boolean {
        return userRepository.addCocktailToFavorites(cocktailId, userId)
    }
}