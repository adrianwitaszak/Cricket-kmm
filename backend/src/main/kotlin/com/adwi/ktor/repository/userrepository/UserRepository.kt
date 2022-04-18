package com.adwi.ktor.repository.userrepository

import com.adwi.ktor.models.User
import com.adwi.ktor.repository.RepositoryInterface

interface UserRepository : RepositoryInterface<User> {
    fun getUserByEmail(email: String? = null): User?
}
