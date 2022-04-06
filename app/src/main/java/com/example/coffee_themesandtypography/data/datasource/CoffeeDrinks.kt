package com.example.coffee_themesandtypography.data

import androidx.annotation.DrawableRes


//1


data class CoffeeDrink(
    val id: Long,
    val name: String,
    @DrawableRes val imageUrl: Int,
    val description: String,
    val ingredients: String,
    val orderDescription: String,
    val price: Double,
    val isFavourite: Boolean
)