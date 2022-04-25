package com.adwi.buddy.models


data class Cocktail(
    override val id: String,
    val name: String,
    val rating: MutableList<Int>,
    val description: String,
    val ingredients: List<String> = emptyList(),
): Model {
    fun addRating(value: Int): Cocktail {
        rating.add(value)
        return this
    }

    fun totalRating(): Int {
        return rating.average().toInt()
    }
}

data class CocktailInput(
    override val id: String
): Model

data class CocktailsPage(
    val results: List<Cocktail>,
    val info: PagingInfo,
)
