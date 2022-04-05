package com.example.coffee_themesandtypography.data

import androidx.annotation.DrawableRes

//1
data class Coffee_Drinks(
    val id :Long,
    val name: String,
    @DrawableRes val imageURL: Int,
    val description: String,
    val ingredients : String,
    val orderDescription: String,
    val price: Double ,
    val isFav: Boolean

)
