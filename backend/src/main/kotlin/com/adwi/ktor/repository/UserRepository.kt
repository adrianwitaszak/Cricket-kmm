package com.adwi.repository

import com.adwi.ktor.models.User
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

private const val DATABASE_NAME = "cricket"
private const val USER_COLLECTION = "users"

class UserRepository(client: MongoClient) : RepositoryInterface<User> {
    override lateinit var col: MongoCollection<User>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection()
    }

    fun getUserByEmail(email: String? = null): User? {
        return try {
            col.findOne(User::email eq email)
        } catch (t: Throwable) {
            throw Exception("Cannot get user with that email")
        }
    }
}