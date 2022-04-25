package com.adwi.buddy.backend.di

import com.adwi.buddy.backend.repository.cocktail.CocktailRepository
import com.adwi.buddy.backend.repository.cocktail.CocktailRepositoryImpl
import com.adwi.buddy.backend.repository.user.DATABASE_NAME
import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.backend.repository.user.UserRepositoryImpl
import com.adwi.buddy.backend.service.AuthService
import com.adwi.buddy.backend.service.CocktailService
import com.adwi.buddy.backend.service.JwtConfig
import com.adwi.buddy.backend.service.UserService
import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.models.User
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.security.InvalidKeyException

private val mongoUri = System.getenv("MONGO_URI") ?: "mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"

val backendModule = module {
    single { JwtConfig("secret") }
    single { KMongo.createClient(mongoUri) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<CocktailRepository> { CocktailRepositoryImpl(get()) }
    single { UserService(get(), get()) }
    single { AuthService(get(), get()) }
    single { CocktailService(get()) }
}
