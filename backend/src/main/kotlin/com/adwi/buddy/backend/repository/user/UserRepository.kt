package com.adwi.buddy.backend.repository.user

import com.adwi.buddy.backend.repository.RepositoryInterface
import com.adwi.buddy.models.User

interface UserRepository: RepositoryInterface<User> {
    fun getUserByEmail(email: String?): User?
}