package com.adwi.buddy.backend.repository.cocktail

import com.adwi.buddy.backend.repository.RepositoryInterface
import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.models.CocktailsPage
import com.adwi.buddy.models.User

interface CocktailRepository: RepositoryInterface<Cocktail> {
    fun getAllPaged(page: Int, size: Int): CocktailsPage

    fun getUserCocktails(user: User): List<Cocktail>
}