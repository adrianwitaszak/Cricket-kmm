package com.adwi.cricket.backend.di

import com.adwi.cricket.backend.repository.userrepository.UserRepositoryImpl
import com.adwi.cricket.backend.service.AuthService
import com.adwi.cricket.backend.service.JwtConfig
import com.adwi.cricket.backend.service.UserService
import org.koin.dsl.module
import org.litote.kmongo.KMongo
import java.security.InvalidKeyException

private val mongoUri = System.getenv("MONGO_URI") ?: InvalidKeyException("Can't get Mongo key")

val appModule = module {
    single { JwtConfig("secret") }
    single { KMongo.createClient("mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority") }
    single { UserRepositoryImpl(get()) }
    single { UserService(get()) }
    single { AuthService(get(), get()) }
}
