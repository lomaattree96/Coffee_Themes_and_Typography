package com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model

data class CoffeeDrinkItem(
    val id: Long,
    val name: String,
    val imageUrl: Int,
    val ingredients: String,
    val description: String,
    val isFavourite: Boolean
)