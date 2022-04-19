package com.adwi.cricket.backend.repository.userrepository

import com.adwi.cricket.backend.models.User
import com.adwi.cricket.backend.repository.RepositoryInterface

interface UserRepository : RepositoryInterface<User> {
    fun getUserByEmail(email: String? = null): User?
}
