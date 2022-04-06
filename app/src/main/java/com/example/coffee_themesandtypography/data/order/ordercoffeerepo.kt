package com.example.coffee_themesandtypography.data.order


import kotlinx.coroutines.flow.Flow

interface OrderCoffeeDrinksRepository {

    suspend fun getCoffeeDrinks(): Flow<List<OrderCoffeeDrink>>

    suspend fun add(coffeeDrinkId: Long): Flow<Boolean>

    suspend fun remove(coffeeDrinkId: Long): Flow<Boolean>
}