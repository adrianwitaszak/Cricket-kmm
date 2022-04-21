package com.adwi.buddy.backend.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    override val id: String,
    val name: String = "",
    val email: String,
    val hashedPass: ByteArray,
) : Model

@Serializable
data class UserInput(
    val email: String,
    val password: String,
)

@Serializable
data class UserProfile(
    val user: User,
    val favoriteCocktails: MutableList<String>
) {
    fun addFavorite(id: String): UserProfile {
        favoriteCocktails.add(id)
        return this
    }

    fun removeFavorite(id: String): UserProfile {
        favoriteCocktails.add(id)
        return this
    }
}

@Serializable
data class UserResponse(
    val token: String,
    val user: User,
)