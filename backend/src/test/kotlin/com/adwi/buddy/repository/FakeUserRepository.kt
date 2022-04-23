package com.adwi.buddy.repository

import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.models.Model
import com.adwi.buddy.models.User
import com.mongodb.client.MongoCollection

class FakeUserRepository(override var col: MongoCollection<User>) : UserRepository {

    private val list = mutableListOf<User>()

    override fun getUserByEmail(email: String?): User? {
        return list.find { it.email == email }
    }

    override fun add(entry: User): User {
        list.add(entry)
        return entry
    }

    override fun getAll(): List<User> {
        return list
    }

    override fun getById(id: String): User {
        return list.find { it.id == id } ?: throw Exception("Cant find user")
    }

    override fun delete(id: String): Boolean {
        val user = getById(id)
        return list.remove(user)
    }

    override fun update(entry: Model): User {
        val user = getById(entry.id)
        list.remove(user)
        return add(user)
    }

    fun clear() {
        list.clear()
    }
}