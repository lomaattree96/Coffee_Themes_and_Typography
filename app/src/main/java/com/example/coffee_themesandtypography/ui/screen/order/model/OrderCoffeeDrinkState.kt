package com.example.coffee_themesandtypography.ui.screen.order.model

import android.icu.math.BigDecimal
import com.example.coffee_themesandtypography.data.order.OrderCoffeeDrink

data class OrderCoffeeDrinkState(
    val coffeeDrinks: List<OrderCoffeeDrink>,
    val totalPrice: BigDecimal
)