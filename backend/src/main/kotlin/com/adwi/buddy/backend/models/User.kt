package com.adwi.buddy.backend.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    override val id: String,
    val name: String = "",
    val email: String,
    val hashedPass: ByteArray,
    val favoriteCocktails: MutableList<String>
) : Model {
    fun addFavorite(id: String): User {
        favoriteCocktails.add(id)
        return this
    }

    fun removeFavorite(id: String): User {
        favoriteCocktails.add(id)
        return this
    }
}

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