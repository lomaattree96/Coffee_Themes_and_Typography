package com.example.coffee_themesandtypography.ui.screen.order


import android.icu.math.BigDecimal
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffee_themesandtypography.data.order.OrderCoffeeDrinksRepository
import com.example.coffee_themesandtypography.ui.screen.order.model.OrderCoffeeDrinkState
import com.example.coffee_themesandtypography.ui.state.UiState
import kotlinx.coroutines.launch


class OrderCoffeeDrinkViewModel(
    private val repository: OrderCoffeeDrinksRepository
) : ViewModel() {
    private val _uiState: MutableLiveData<UiState<OrderCoffeeDrinkState>> = MutableLiveData()
    val uiState: LiveData<UiState<OrderCoffeeDrinkState>>
        get() = _uiState

    fun loadDrinks() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getCoffeeDrinks()
                .collect { ccoffeeDrinks ->
                    val totalCount = ccoffeeDrinks
                        .filter { it.count  > 0}
                        .map { it.count * it.price }
                        .sum()

                    _uiState.value = UiState.Success(
                        OrderCoffeeDrinkState(
                            coffeeDrinks = ccoffeeDrinks,
                            totalPrice = BigDecimal(totalCount)
                        )
                    )
                }
        }
    }

    fun addDrink(coffeeDrinkId: Long) {
        viewModelScope.launch {
            repository.add(coffeeDrinkId)
                .collect { isAdded ->
                    if (isAdded) {
                        loadDrinks()
                    }
                }
        }
    }

    fun removeDrink(coffeeDrinkId: Long) {
        viewModelScope.launch {
            repository.remove(coffeeDrinkId)
                .collect { isRemoved ->
                    if (isRemoved) {
                        loadDrinks()
                    }
                }
        }
    }
}


