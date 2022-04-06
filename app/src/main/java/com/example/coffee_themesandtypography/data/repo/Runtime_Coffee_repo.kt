package com.example.coffee_themesandtypography.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

/**object RuntimeCoffeeDrinkRepository : CoffeeDrinkRepository{
    private val coffeeDrinks: MutableList<CoffeeDrink> = initCoffeeDrinks()

    override suspend fun getCoffeeDrinks(): Flow<List<CoffeeDrink>> {
        return flowOf(coffeeDrinks)
    }

    override suspend fun getCoffeeDrink(id: Long): Flow<CoffeeDrink?> {
        return flowOf(
            coffeeDrinks.firstOrNull { it.id == id }
        )
    }




    private fun initCoffeeDrinks(): MutableList<CoffeeDrink> {
        return DummyCoffeeDrinksDataSource().getCoffeeDrinks() as MutableList<CoffeeDrink>
    }
}
**/