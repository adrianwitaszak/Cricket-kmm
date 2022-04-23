package com.adwi.buddy.backend.service

import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.backend.repository.cocktail.CocktailRepository
import com.adwi.buddy.backend.repository.user.UserRepositoryImpl
import com.adwi.buddy.models.CocktailsPage

class CocktailService(
    private val cocktailRepository: CocktailRepository,
    private val userRepository: UserRepositoryImpl
) {
    fun getAll(): List<Cocktail> {
        return cocktailRepository.getAll()
    }
    fun getAllPaged(page:Int, size: Int = 20): CocktailsPage {
        return cocktailRepository.getAllPaged(page, size)
    }

    fun getAllWithFilteredIngredients(ingredients: List<String>, include: Boolean): List<Cocktail> {
        val cocktails = cocktailRepository.getAll()
        return ingredients.flatMap { ingredientName ->
            cocktails.filter { cocktail ->
                cocktail.ingredients.contains(ingredientName) == include
            }
        }
    }

    fun rateCocktail(cocktail: Cocktail, rating: Int): Int {
        val newCocktail = cocktail.addRating(rating)
        cocktailRepository.update(newCocktail)
        return newCocktail.totalRating()
    }
}