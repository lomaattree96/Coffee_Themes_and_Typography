package com.example.coffee_themesandtypography.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

object RuntimeCoffeeDrinkRepository : CoffeeDrinkRepo{
    private val coffeeDrinks: MutableList<Coffee_Drinks> = initCoffeeDrinks()

    override suspend fun getCoffeeDrinks(): Flow<List<Coffee_Drinks>> {
        return flowOf(coffeeDrinks)
    }

    override suspend fun getCoffeeDrinks(id: Long): Flow<Coffee_Drinks?> {
        return flowOf(
            coffeeDrinks.firstOrNull { it.id == id }
        )
    }

    override suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean> {
        return flow {
            val position = coffeeDrinks.indexOfFirst { it.id == id }
            val result = if (position > -1) {
                val oldCoffeeDrink = coffeeDrinks.first { it.id == id }
                val newCoffeeDrink = oldCoffeeDrink.copy(isFav = newFavouriteState)
                coffeeDrinks.remove(oldCoffeeDrink)
                coffeeDrinks.add(position, newCoffeeDrink)
                true
            } else {
                false
            }
            emit(result)
        }
    }

    private fun initCoffeeDrinks(): MutableList<Coffee_Drinks> {
        return Dummydata().getCoffeeDrinks() as MutableList<Coffee_Drinks>
    }
}