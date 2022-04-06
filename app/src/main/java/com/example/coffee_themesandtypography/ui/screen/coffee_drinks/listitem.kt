package com.example.coffee_themesandtypography.ui.screen.coffee_drinks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee_themesandtypography.data.DummyCoffeeDrinksDataSource

import com.example.coffee_themesandtypography.ui.component.App_Divider
import com.example.coffee_themesandtypography.ui.component.Fav
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.mapper.CoffeeDrinkItemMapper
import com.example.coffee_themesandtypography.ui.screen.coffee_drinks.model.CoffeeDrinkItem
import com.example.coffee_themesandtypography.ui.theme.appTypography

private val COFFEE_DRINK_IMAGE_SIZE = 72.dp

@Preview
@Composable
fun PreviewListItem() {
    val mapper = CoffeeDrinkItemMapper()
    val coffeeDrink = mapper.map(
       DummyCoffeeDrinksDataSource().getCoffeeDrinks().first()
    )

    MaterialTheme(colors = lightColors(), typography = appTypography) {
        CoffeeDrinkListItem(
            coffeeDrink = coffeeDrink,
            onFavouriteStateChanged = {}
        )
    }
}

@Composable
fun CoffeeDrinkList(
    coffeeDrink: CoffeeDrinkItem,
    onFavouriteStateChanged: (CoffeeDrinkItem) -> Unit
) {
    Column {
        CoffeeDrinkListItem(
            coffeeDrink = coffeeDrink,
            onFavouriteStateChanged = { onFavouriteStateChanged(it) }
        )
        App_Divider(PaddingValues(start = COFFEE_DRINK_IMAGE_SIZE))
    }
}

@Composable
fun CoffeeDrinkListItem(
    coffeeDrink: CoffeeDrinkItem,
    onFavouriteStateChanged: (CoffeeDrinkItem) -> Unit
) {
    Row {
        CoffeeDrinkLogo(id = coffeeDrink.imageUrl)
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column {
                CoffeeDrinkTitle(title = coffeeDrink.name)
                CoffeeDrinkIngredient(ingredients = coffeeDrink.ingredients)
            }
        }
        CoffeeDrinkFavouriteIcon(
            tint = if (isSystemInDarkTheme()) {
                MaterialTheme.colors.onPrimary
            } else {
                MaterialTheme.colors.primaryVariant
            },
            favouriteState = coffeeDrink.isFavourite,
            onValueChanged = { onFavouriteStateChanged(coffeeDrink) }
        )
    }
}

@Composable
private fun CoffeeDrinkLogo(@DrawableRes id: Int) {
    Surface(
        modifier = Modifier.size(COFFEE_DRINK_IMAGE_SIZE)
            .padding(8.dp),
        shape = CircleShape,
        color = Color(0xFFFAFAFA)
    ) {
        Image(
            painter = BitmapPainter(ImageBitmap.imageResource(id = id)),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
    }
}

@Composable
private fun CoffeeDrinkTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 8.dp, end = 8.dp),
        style = TextStyle(fontSize = 24.sp),
        color = MaterialTheme.colors.onSurface,
        maxLines = 1
    )
}

@Composable
private fun CoffeeDrinkIngredient(ingredients: String) {
    Text(
        text = ingredients,
        modifier = Modifier.padding(end = 8.dp)
            .alpha(0.54f),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
private fun CoffeeDrinkFavouriteIcon(
    tint: Color = MaterialTheme.colors.onSurface,
    favouriteState: Boolean,
    onValueChanged: (Boolean) -> Unit
) {
    Fav(
        state = favouriteState,
        onValueChanged = onValueChanged,
        tint = tint
    )
}