@file:JvmName("KoinTest")
package com.example.coffee_themesandtypography

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.logging.Level

//import org.koin.android.ext.koin.androidContext
//import org.koin.android.ext.koin.androidLogger
//import org.koin.core.context.startKoin
//import org.koin.core.logger.Level

//0

@HiltAndroidApp
class CoffeeDrinksApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //initDI()
    }
}

   /** private fun initDI() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CoffeeDrinksApp)
            modules(
                listOf(
                    dataModule,
                    mapperModule,
                    viewModelModule
                )
            )
        }
    }
}

**/