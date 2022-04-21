package com.adwi.buddy.backend.repository.cocktail

import com.adwi.buddy.backend.models.Cocktail
import com.adwi.buddy.backend.repository.RepositoryInterface
import com.adwi.buddy.backend.repository.userrepository.DATABASE_NAME
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection

private const val COCKTAILS_COLLECTION = "cocktails"

class CocktailRepository(client: MongoClient): RepositoryInterface<Cocktail> {

    override lateinit var col: MongoCollection<Cocktail>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection()
    }
}