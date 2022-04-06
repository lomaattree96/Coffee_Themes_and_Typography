package com.example.coffee_themesandtypography.ui.screen.order.mapper

import androidx.compose.runtime.mutableStateOf
import com.example.coffee_themesandtypography.data.CoffeeDrink
import com.example.coffee_themesandtypography.ui.screen.order.mapper.OrderCoffeeDrinkMapper
import com.example.coffee_themesandtypography.ui.screen.order.model.OrderCoffeeDrink



class OrderCoffeeDrinkMapper {

    fun map(coffeeDrink: CoffeeDrink): OrderCoffeeDrink {
        return OrderCoffeeDrink(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageRes = coffeeDrink.imageUrl,
            description = coffeeDrink.orderDescription,
            price = coffeeDrink.price,
            count = mutableStateOf(0)
        )
    }
}