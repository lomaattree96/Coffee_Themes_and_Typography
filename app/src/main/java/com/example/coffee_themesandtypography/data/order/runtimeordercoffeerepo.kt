package com.example.coffee_themesandtypography.data.order

import com.example.coffee_themesandtypography.data.Drink_Coffee_datasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RuntimeOrderCoffeeRepo(
    private val coffeeDrinkDataSource: Drink_Coffee_datasource,
    private val orderCoffeeDrinkMapper: Ordercoffeemapper
) : OrderCoffeeDrinksRepository {
    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 99
    }

    private val coffeeDrinks = mutableListOf<Order_Coffee_Drinks>()

    override suspend fun getCoffeeDrinks(): Flow<List<Order_Coffee_Drinks>> {
        return flow {
            if (coffeeDrinks.isEmpty()) {
                coffeeDrinks.addAll(
                    orderCoffeeDrinkMapper.map(coffeeDrinkDataSource.getCoffeeDrinks())
                )
            }
            emit(coffeeDrinks)
        }
    }

    override suspend fun add(coffeeDrinkId: Long): Flow<Boolean> {
        return flow {
            val index = coffeeDrinks.indexOfFirst { it.id == coffeeDrinkId }
            val result = if (index > -1) {
                val coffeeDrink = coffeeDrinks[index]
                val newValue =
                    if (coffeeDrink.count == MAX_VALUE) MAX_VALUE else coffeeDrink.count + 1
                coffeeDrinks[index] = coffeeDrink.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }

    override suspend fun remove(coffeeDrinkId: Long): Flow<Boolean> {
        return flow {
            val index = coffeeDrinks.indexOfFirst { it.id == coffeeDrinkId }
            val result = if (index > -1) {
                val coffeeDrink = coffeeDrinks[index]
                val newValue =
                    if (coffeeDrink.count == MIN_VALUE) MIN_VALUE else coffeeDrink.count - 1
                coffeeDrinks[index] = coffeeDrink.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }
}