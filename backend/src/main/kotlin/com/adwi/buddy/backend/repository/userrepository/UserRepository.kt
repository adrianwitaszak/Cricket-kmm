package com.adwi.buddy.backend.repository.userrepository

import com.adwi.buddy.backend.models.User
import com.adwi.buddy.backend.repository.RepositoryInterface

interface UserRepository : RepositoryInterface<User> {
    fun getUserByEmail(email: String? = null): User?
}
