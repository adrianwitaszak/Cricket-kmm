package com.adwi.buddy.backend.repository

import com.adwi.buddy.backend.models.User
import com.adwi.buddy.backend.repository.RepositoryInterface
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

const val DATABASE_NAME = "cricket"
private const val USER_COLLECTION = "users"

class UserRepository(client: MongoClient) : RepositoryInterface<User> {

    override lateinit var col: MongoCollection<User>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection()
    }

    fun getUserByEmail(email: String?): User? {
        return try {
            col.findOne(User::email eq email)
        } catch (t: Throwable) {
            throw Exception("Cannot get user with that email")
        }
    }

    fun addCocktailToFavorites(cocktailId: String, userId: String): Boolean {
        return try {
            val user = getById(userId)
            val updatedUser = user.addFavorite(cocktailId)
            val remoteUser = update(updatedUser)
            remoteUser == updatedUser
        } catch (e: Exception) {
            println(e)
            false
        }
    }
}