package com.adwi.buddy.repository

import com.adwi.buddy.backend.repository.cocktail.CocktailRepository
import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.models.CocktailsPage
import com.adwi.buddy.models.Model
import com.adwi.buddy.models.User
import com.mongodb.client.MongoCollection

class FakeCocktailRepository(override var col: MongoCollection<Cocktail>) : CocktailRepository {

    private val list = mutableListOf<Cocktail>()

    override fun getAllPaged(page: Int, size: Int): CocktailsPage {
        TODO("Not yet implemented")
    }

    override fun add(entry: Cocktail): Cocktail {
        list.add(entry)
        return entry
    }

    override fun getAll(): List<Cocktail> {
        return list
    }

    override fun getById(id: String): Cocktail {
        return list.find { it.id == id } ?: throw Exception("Cant find Cocktail")
    }

    override fun delete(id: String): Boolean {
        val user = getById(id)
        return list.remove(user)
    }

    override fun update(entry: Model): Cocktail {
        val user = getById(entry.id)
        list.remove(user)
        return add(user)
    }
}