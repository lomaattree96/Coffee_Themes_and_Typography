package com.example.coffee_themesandtypography.ui.navigation

import android.os.Bundle
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.findNavController
import com.example.coffee_themesandtypography.R
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.ShowSuccessCoffeeDrinkDetailsScreen
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.model.CoffeeDrinkDetailState
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.CoffeeDrinksScreenUI
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.ShowSuccessCoffeeDrinksScreen
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.CoffeeDrinksState
import com.example.coffee_themesandtypography.ui.screen.order.OrderCoffeeDrinkItem
import com.example.coffee_themesandtypography.ui.screen.order.ShowSuccessOrderCoffeeDrinksScreen

enum class Screen {
    CoffeeDrinks,
    CoffeeDrinkDetails,
    OrderCoffeeDrinks
}

/**sealed class Coffee_Screen(val route: String) {
    object CoffeeDrinks: Coffee_Screen("CoffeeDrinks")
    object CoffeeDrinkDetails: Coffee_Screen("CoffeeDrinkDetails")
    object  OrderCoffeeDrinks:Coffee_Screen(" OrderCoffeeDrinks")
}**/

/**@ExperimentalAnimationApi
@Composable
private fun NoteAppTheme() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Coffee_Screen.CoffeeDrinks.route
        ) {
            composable(route = Coffee_Screen.CoffeeDrinkDetails.route) {
                ShowSuccessCoffeeDrinksScreen(
                    CoffeeDrinkDetailState,
                    navController = navController)
            }
            composable(
                route = Coffee_Screen.CoffeeDrinkDetails.route){
                 /**      // "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                    navArgument(
                        name = "noteColor"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                )**/
                ShowSuccessCoffeeDrinkDetailsScreen(

                    navController = navController,)
            }

                 composable(
                     route = Coffee_Screen.OrderCoffeeDrinks.route
                 ){
                     ShowSuccessOrderCoffeeDrinksScreen(
                         navController = navController,

                         )


                 }

        }
    }
}
**/



fun Fragment.navigate(from: Screen, to: Screen, bundle: Bundle? = null) {
    val id = mapScreenToId(from, to)
    if (bundle == null) {
        findNavController().navigate(id)
    } else {
        findNavController().navigate(id, Bundle())
    }
}

fun Fragment.navigateToPreviousScreen(from: Screen, to: Screen) {
    val id = mapScreenToId(from, to)
    findNavController().popBackStack(id, false)
}

private fun mapScreenToId(from: Screen, to: Screen):Int {
    if (to == from) {
        throw IllegalArgumentException("Cannot navigate from $from to $to")
    }


    return when (to) {

        Screen.CoffeeDrinks -> R.id.coffeeDrinksFragment
        Screen.CoffeeDrinkDetails ->   R.id.coffeeDrinkDetailsFragment
        Screen.OrderCoffeeDrinks ->    R.id.orderCoffeeDrinkFragment
    }
}

