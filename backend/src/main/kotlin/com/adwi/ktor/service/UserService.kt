package com.adwi.ktor.service

import com.adwi.ktor.models.UserProfile
import com.adwi.ktor.repository.userrepository.UserRepositoryImpl

class UserService(
    private val userRepositoryImpl: UserRepositoryImpl,
) {
    fun getProfile(userId: String): UserProfile {
        val user = userRepositoryImpl.getById(userId)
        return UserProfile(user)
    }
}