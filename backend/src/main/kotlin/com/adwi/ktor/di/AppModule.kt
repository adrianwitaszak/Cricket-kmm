package com.adwi.ktor.di

import com.adwi.ktor.repository.UserRepository
import com.adwi.ktor.service.AuthService
import com.adwi.ktor.service.JwtConfig
import com.adwi.ktor.service.UserService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import java.security.InvalidKeyException

private val mongoUri = System.getenv("MONGO_URI") ?: InvalidKeyException("Can't get Mongo key")

val appModule = module {
    single { JwtConfig("secret") }
    single { KMongo.createClient("mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority") }
    single { UserRepository(get()) }
    single { UserService(get()) }
    single { AuthService(get(), get()) }
}
