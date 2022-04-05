package com.example.coffee_themesandtypography.data.order

import androidx.annotation.DrawableRes

data class Order_Coffee_Drinks(
    val id :Long,
    val name: String,
    @DrawableRes val imageURL: Int,
    val ingredients : String,
    val price: Double,
    val count: Int

)