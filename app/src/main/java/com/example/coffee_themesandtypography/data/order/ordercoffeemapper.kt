package com.example.coffee_themesandtypography.data.order

import com.example.coffee_themesandtypography.data.Coffee_Drinks

class Ordercoffeemapper{

    fun map(coffeeDrink: Coffee_Drinks, count: Int = 0): Order_Coffee_Drinks {
        return Order_Coffee_Drinks(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageURL = coffeeDrink.imageURL,
            ingredients = coffeeDrink.ingredients,
            price = coffeeDrink.price,
            count = count
        )
    }

    fun map(coffeeDrinks: List<Coffee_Drinks>, count: Int = 0): List<Order_Coffee_Drinks> {
        return coffeeDrinks.map { map(it, count) }
    }
}
