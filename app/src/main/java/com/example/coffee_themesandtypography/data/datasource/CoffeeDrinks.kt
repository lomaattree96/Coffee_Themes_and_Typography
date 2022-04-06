package com.example.coffee_themesandtypography.data

import androidx.annotation.DrawableRes
import androidx.room.Entity

//1

@Entity(tableName= "drinkcoffee_tbl")
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