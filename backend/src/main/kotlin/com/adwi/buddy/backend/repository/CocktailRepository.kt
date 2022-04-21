package com.adwi.buddy.backend.repository

import com.adwi.buddy.backend.models.Cocktail
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection

class CocktailRepository(client: MongoClient): RepositoryInterface<Cocktail> {

    override lateinit var col: MongoCollection<Cocktail>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection()
    }
}