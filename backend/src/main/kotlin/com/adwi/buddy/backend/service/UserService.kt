package com.adwi.buddy.backend.service

import com.adwi.buddy.backend.models.UserProfile
import com.adwi.buddy.backend.repository.userrepository.UserRepositoryImpl

class UserService(
    private val userRepositoryImpl: UserRepositoryImpl,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepositoryImpl.getById(userId)
        return UserProfile(user)
    }
}