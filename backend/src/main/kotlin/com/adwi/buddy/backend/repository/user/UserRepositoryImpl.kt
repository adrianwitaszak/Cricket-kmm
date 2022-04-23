package com.adwi.buddy.backend.repository.user

import com.adwi.buddy.models.User
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

const val DATABASE_NAME = "cricket"
private const val USER_COLLECTION = "users"

class UserRepositoryImpl(override var col: MongoCollection<User>) : UserRepository {



    init {

    }

    override fun getUserByEmail(email: String?): User? {
        return try {
            col.findOne(User::email eq email)
        } catch (t: Throwable) {
            throw Exception("Cannot get user with that email")
        }
    }
}