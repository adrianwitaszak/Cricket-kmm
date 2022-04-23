package com.adwi.buddy.backend.di

import com.adwi.buddy.backend.repository.cocktail.CocktailRepositoryImpl
import com.adwi.buddy.backend.repository.user.DATABASE_NAME
import com.adwi.buddy.backend.repository.user.UserRepositoryImpl
import com.adwi.buddy.backend.service.AuthService
import com.adwi.buddy.backend.service.JwtConfig
import com.adwi.buddy.backend.service.UserService
import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.models.User
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.security.InvalidKeyException

private val mongoUri = System.getenv("MONGO_URI") ?: InvalidKeyException("Can't get Mongo key")

val backendModule = module {

    val mongoClient = KMongo.createClient("mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority")
    val database = mongoClient.getDatabase(DATABASE_NAME)

    val userMongoCollection = database.getCollection<User>()
    val cocktailMongoCollection = database.getCollection<Cocktail>()

    single { JwtConfig("secret") }
    single { userMongoCollection }
    single { cocktailMongoCollection }
    single { UserRepositoryImpl(get()) }
    single { CocktailRepositoryImpl(get()) }
    single { UserService(get()) }
    single { AuthService(get(), get()) }
}
