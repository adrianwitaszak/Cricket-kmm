package com.adwi.buddy.backend.di

import com.adwi.buddy.backend.repository.UserRepositoryImpl
import com.adwi.buddy.backend.service.AuthService
import com.adwi.buddy.backend.service.JwtConfig
import com.adwi.buddy.backend.service.UserService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import java.security.InvalidKeyException

private val mongoUri = System.getenv("MONGO_URI") ?: InvalidKeyException("Can't get Mongo key")

val backendModule = module {
    single { JwtConfig("secret") }
    single { KMongo.createClient("mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority") }
    single { UserRepositoryImpl(get()) }
    single { UserService(get()) }
    single { AuthService(get(), get()) }
}
