package com.example.coffee_themesandtypography.ui.screen.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.coffee_themesandtypography.R
import com.example.coffee_themesandtypography.ui.state.UiState
import com.example.coffee_themesandtypography.ui.theme.CoffeeThemesAndTypographyTheme

/**class OrderCoffeeDrinkFragment : Fragment() {
    private val viewModel: OrderCoffeeDrinkViewModel by viewModel()

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
                                ShowLoadingOrderCoffeeDrinksScreen()
                            }
                            is UiState.Success -> {
                                ShowSuccessOrderCoffeeDrinksScreen(
                                    orderCoffeeDrinkState = uiState.data,
                                    viewModel = viewModel,
                                    onBack = {
                                        this@OrderCoffeeDrinkFragment.navigateToPreviousScreen(
                                            Screen.OrderCoffeeDrinks,
                                            Screen.CoffeeDrinks
                                        )
                                    }
                                )
                            }
                            is UiState.Error -> {
                                ShowErrorOrderCoffeeDrinksScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadDrinks()
    }
}
**/