package com.example.coffee_themesandtypography.di


import com.example.coffee_themesandtypography.data.CoffeeDrinkDataSource
import com.example.coffee_themesandtypography.data.CoffeeDrinkRepository
import com.example.coffee_themesandtypography.data.DummyCoffeeDrinksDataSource
import com.example.coffee_themesandtypography.data.RuntimeCoffeeDrinkRepository
import com.example.coffee_themesandtypography.data.order.OrderCoffeeDrinkMapper

import com.example.coffee_themesandtypography.data.order.OrderCoffeeDrinksRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import com.example.coffee_themesandtypography.data.order.RuntimeOrderCoffeeDrinksRepository
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.CoffeeDrinkDetailsViewModel
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.mapper.CoffeeDrinkDetailMapper
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.CoffeeDrinksViewModel
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.mapper.CoffeeDrinkItemMapper
import com.example.coffee_themesandtypography.ui.screen.order.OrderCoffeeDrinkViewModel

 val dataModule = module {
    factory<CoffeeDrinkDataSource> { DummyCoffeeDrinksDataSource() }
    single<CoffeeDrinkRepository> { RuntimeCoffeeDrinkRepository }
    single<OrderCoffeeDrinksRepository> {
        RuntimeOrderCoffeeDrinksRepository(
            coffeeDrinkDataSource = get(),
            orderCoffeeDrinkMapper = get()
        )
    }
}

val mapperModule = module {
    factory { CoffeeDrinkItemMapper() }
    factory { CoffeeDrinkDetailMapper() }
    factory { OrderCoffeeDrinkMapper() }

    factory { OrderCoffeeDrinkMapper() }
}

val viewModelModule = module {
    viewModel {
        OrderCoffeeDrinkViewModel(
            repository = get()
        )
    }
    viewModel {
        CoffeeDrinksViewModel(
            repository = get(),
            mapper = get()
        )
    }
    viewModel {
        CoffeeDrinkDetailsViewModel(
            repository = get(),
            mapper = get()
        )
    }
}

