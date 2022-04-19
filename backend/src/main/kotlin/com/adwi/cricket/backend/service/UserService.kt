package com.adwi.cricket.backend.service

import com.adwi.cricket.backend.models.UserProfile
import com.adwi.cricket.backend.repository.userrepository.UserRepositoryImpl

class UserService(
    private val userRepositoryImpl: UserRepositoryImpl,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepositoryImpl.getById(userId)
        return UserProfile(user)
    }
}