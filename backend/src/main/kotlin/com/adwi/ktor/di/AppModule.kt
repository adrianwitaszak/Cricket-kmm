package com.adwi.ktor.di

import com.adwi.repository.UserRepository
import com.adwi.service.AuthService
import com.adwi.service.UserService
import io.ktor.server.config.*
import org.koin.dsl.module
import org.litote.kmongo.KMongo

val appModule = module {
    single { KMongo.createClient("mongodb+srv://adrianwitaszak:Anabelle2013@cricket.hwwlg.mongodb.net/myFirstDatabase?retryWrites=true&w=majority") }
    single { UserRepository(get()) }
    single { UserService(get()) }
    single { AuthService(get(), "secret") }
}

