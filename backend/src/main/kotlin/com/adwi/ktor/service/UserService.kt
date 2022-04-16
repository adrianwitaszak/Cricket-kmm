package com.adwi.service

import com.adwi.models.UserProfile
import com.adwi.repository.UserRepository

class UserService(
    private val userRepository: UserRepository,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepository.getById(userId)
        return UserProfile(user)
    }
}