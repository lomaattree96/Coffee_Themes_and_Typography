package com.example.coffee_themesandtypography.data.order

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState

data class OrderCoffeeDrink(
    val id: Long,
    val name: String,
    @DrawableRes val imageUrl: Int,
    val ingredients: String,
    val price: Double,
    val count: Int
)
