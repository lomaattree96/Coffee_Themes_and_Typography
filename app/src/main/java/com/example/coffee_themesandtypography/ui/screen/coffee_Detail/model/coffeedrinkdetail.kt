package com.example.coffee_themesandtypography.ui.screen.coffee_Detail.model

data class CoffeeDrinkDetail(
    val id: Long,
    val name: String,
    val imageUrl: Int,
    val ingredients: String,
    val description: String,
    var isFavourite: Boolean
)