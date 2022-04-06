package com.example.coffee_themesandtypography.ui.screen.coffee_drinks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffee_themesandtypography.data.CoffeeDrinkRepository
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.mapper.CoffeeDrinkItemMapper
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.CoffeeDrinkItem
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.CoffeeDrinksState
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.DisplayingOptions
import com.example.coffee_themesandtypography.ui.state.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CoffeeDrinksViewModel(
    private val repository: CoffeeDrinkRepository,
    private val mapper: CoffeeDrinkItemMapper
) : ViewModel() {
    private var currentDisplayingOption = DisplayingOptions.LIST

    private val _uiState: MutableLiveData<UiState<CoffeeDrinksState>> = MutableLiveData()
    val uiState: LiveData<UiState<CoffeeDrinksState>>
        get() = _uiState

    fun loadCoffeeDrinks() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getCoffeeDrinks()
                .map { coffeeDrinks ->
                    coffeeDrinks.map { mapper.map(it) }
                }
                .collect {
                    _uiState.value = UiState.Success(
                        CoffeeDrinksState(
                            it,
                            currentDisplayingOption
                        )
                    )
                }
        }
    }

    fun changeDisplayingOption() {
        when (val state = _uiState.value) {
            is UiState.Success -> {
                currentDisplayingOption = if (currentDisplayingOption == DisplayingOptions.LIST) {
                    DisplayingOptions.CARDS
                } else {
                    DisplayingOptions.LIST
                }
                _uiState.value = UiState.Success(state.data.copy(displayingOption = currentDisplayingOption))
            }
            else -> loadCoffeeDrinks()
        }
    }

    fun changeFavouriteState(coffeeDrink: CoffeeDrinkItem) {
        viewModelScope.launch {
            repository.updateFavouriteState(coffeeDrink.id, !coffeeDrink.isFavourite)
                .collect { result ->
                    if (result) {
                        loadCoffeeDrinks()
                    }
                }
        }
    }
}