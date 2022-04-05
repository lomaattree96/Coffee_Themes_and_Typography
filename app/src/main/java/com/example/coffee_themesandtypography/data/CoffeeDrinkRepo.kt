package com.example.coffee_themesandtypography.data

import kotlinx.coroutines.flow.Flow

interface CoffeeDrinkRepo {
    suspend fun getCoffeeDrinks() :Flow<List<Coffee_Drinks>>

    suspend fun getCoffeeDrinks(id:Long) :Flow<List<Coffee_Drinks>>

    suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean>
}