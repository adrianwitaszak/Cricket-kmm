package com.adwi.ktor.service

import com.adwi.ktor.models.UserProfile
import com.adwi.ktor.repository.UserRepository

class UserService(
    private val userRepository: UserRepository,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepository.getById(userId)
        return UserProfile(user)
    }
}