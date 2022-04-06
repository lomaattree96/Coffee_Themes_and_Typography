package com.example.coffee_themesandtypography.ui.screen.coffee_drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.compose.runtime.livedata.observeAsState
import com.example.coffee_themesandtypography.R
import com.example.coffee_themesandtypography.ui.navigation.Screen
import com.example.coffee_themesandtypography.ui.navigation.navigate
import com.example.coffee_themesandtypography.ui.state.UiState
import com.example.coffee_themesandtypography.ui.theme.CoffeeThemesAndTypographyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class CoffeeDrinksFragment : Fragment() {
    private val viewModel: CoffeeDrinksViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            id = R.id.coffeeDrinkDetailsFragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            setContent {
              CoffeeThemesAndTypographyTheme {
                    viewModel.uiState.observeAsState(initial = UiState.Loading).value.let { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                ShowLoadingCoffeeDrinksScreen()
                            }
                            is UiState.Success -> {
                                ShowSuccessCoffeeDrinksScreen(
                                    coffeeDrinksState = uiState.data,
                                    viewModel = viewModel,
                                    onOrderCoffeeDrinksMenuItem = {
                                        this@CoffeeDrinksFragment.navigate(
                                            Screen.CoffeeDrinks,
                                            Screen.OrderCoffeeDrinks
                                        )
                                    },
                                    onCoffeeDrinkClicked = { coffeeDrink ->
                                        this@CoffeeDrinksFragment.navigate(
                                            Screen.CoffeeDrinks,
                                            Screen.CoffeeDrinkDetails,
                                            bundleOf("id" to coffeeDrink.id)
                                        )
                                    }
                                )
                            }
                            is UiState.Error -> {
                                ShowErrorCoffeeDrinksScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCoffeeDrinks()
    }
}


