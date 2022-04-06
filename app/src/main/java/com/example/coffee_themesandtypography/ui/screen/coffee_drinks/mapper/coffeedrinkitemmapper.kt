package com.example.coffee_themesandtypography.ui.screen.coffee_drinks.mapper

import com.example.coffee_themesandtypography.data.CoffeeDrink
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.CoffeeDrinkItem

class CoffeeDrinkItemMapper {

    fun map(coffeeDrink: CoffeeDrink): CoffeeDrinkItem {
        return CoffeeDrinkItem(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageUrl = coffeeDrink.imageUrl,
            ingredients = coffeeDrink.ingredients,
            description = coffeeDrink.description,
            isFavourite = coffeeDrink.isFavourite
        )
    }
}
