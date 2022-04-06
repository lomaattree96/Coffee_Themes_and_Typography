package com.example.coffee_themesandtypography.ui.screen.coffee_Detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment




import com.example.coffee_themesandtypography.R
import com.example.coffee_themesandtypography.data.CoffeeDrinkRepository


import com.example.coffee_themesandtypography.ui.navigation.Screen
import com.example.coffee_themesandtypography.ui.navigation.navigateToPreviousScreen
import com.example.coffee_themesandtypography.ui.screen.coffee_Detail.mapper.CoffeeDrinkDetailMapper
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coffee_themesandtypography.ui.state.UiState
import com.example.coffee_themesandtypography.ui.theme.CoffeeThemesAndTypographyTheme
import androidx.compose.runtime.livedata.observeAsState as observeAsState

class CoffeeDrinkDetailsFragment : Fragment() {
    private val viewModel: CoffeeDrinkDetailsViewModel by viewModel()

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
                                ShowLoadingCoffeeDrinkDetailsScreen()
                            }
                            is UiState.Success -> {
                                ShowSuccessCoffeeDrinkDetailsScreen(
                                    onBack = {
                                        this@CoffeeDrinkDetailsFragment.navigateToPreviousScreen(
                                            Screen.CoffeeDrinkDetails,
                                            Screen.CoffeeDrinks
                                        )
                                    },
                                    coffeeDrinkDetailState = uiState.data,
                                    viewModel = viewModel
                                )
                            }
                            is UiState.Error -> {
                                ShowErrorCoffeeDrinkDetailsScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCoffeeDrinkDetails(arguments?.getLong("id") ?: -1)
    }
}
