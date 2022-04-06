package com.example.coffee_themesandtypography.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coffee_themesandtypography.data.CoffeeDrinkDataSource
import com.example.coffee_themesandtypography.data.CoffeeDrinkRepository
import com.example.coffee_themesandtypography.data.DummyCoffeeDrinksDataSource
import com.example.coffee_themesandtypography.data.order.OrderCoffeeDrinksRepository
import com.example.coffee_themesandtypography.data.repo.RuntimeCoffeeDrinkRepository


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingspotDatabase {
        return Room.databaseBuilder(
            app,
            ParkingspotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingspotDatabase): CoffeeDrinkRepo {
        return ParkingSpot_repo_impl(db.dao)
    }
}**/

/**
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCoffeeDrinkDataSource(app: Application): CoffeeDrinkRepository {
        return Room.databaseBuilder(
            app,
            ::class.java,
            "drinkcoffee.db"
        ).build()


    }
}
/**val dataModule  ():DummyCoffeeDrinksDataSource {
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

        factory { com.alexzh.coffeedrinks.data.order.OrderCoffeeDrinkMapper() }
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

 **/