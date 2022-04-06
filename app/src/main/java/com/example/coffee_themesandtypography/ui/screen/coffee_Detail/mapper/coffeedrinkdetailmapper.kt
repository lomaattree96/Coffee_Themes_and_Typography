package com.example.coffee_themesandtypography.ui.screen.coffee_Detail.mapper

import com.example.coffee_themesandtypography.data.CoffeeDrink
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.model.CoffeeDrinkDetail


class CoffeeDrinkDetailMapper {

    fun map(coffeeDrink: CoffeeDrink?): CoffeeDrinkDetail? {
        if (coffeeDrink == null) {
            return null
        }

        return CoffeeDrinkDetail(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageUrl = coffeeDrink.imageUrl,
            ingredients = coffeeDrink.ingredients,
            description = coffeeDrink.description,
            isFavourite = coffeeDrink.isFavourite
        )
    }
}