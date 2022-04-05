package com.example.coffee_themesandtypography.ui.component


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color


@Composable
fun App_Divider(
    padding:PaddingValues = PaddingValues()
){
    Divider(
        modifier = Modifier
            .padding(padding)
            .alpha(0.12f),
        color = if (isSystemInDarkTheme()) {
            Color.White
        } else {
            Color.Black
        }
    )

}