package com.adwi.buddy.backend.service

import com.adwi.buddy.backend.models.UserProfile
import com.adwi.buddy.backend.repository.userrepository.UserRepository

class UserService(
    private val userRepository: UserRepository,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepository.getById(userId)
        return UserProfile(user)
    }
}