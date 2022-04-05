package com.example.coffee_themesandtypography.data

import com.example.coffee_themesandtypography.R

//dummy data source for  drinking -- coffee

//3
class Dummydata : Drink_Coffee_datasource{
    override fun getCoffeeDrinks(): List<Coffee_Drinks> {
        return mutableListOf(
            Coffee_Drinks(
                id = 1L,
                name = "Americano",
                imageURL = R.drawable.cappuccino_small,
                description = "Americano is a type of coffee drink prepared by diluting an espresso with hot water, giving it a similar strength to, but different flavour from, traditionally brewed coffee. ",
                ingredients = "Espresso, Water",
                orderDescription = "150 ml",
                price = 6.5,
                isFav = false
            ),
            Coffee_Drinks(
                id = 2L,
                name = "Cappuccino",
                imageURL = R.drawable.cappuccino_small,
                description = "A cappuccino is an espresso-based coffee drink that originated in Italy, and is traditionally prepared with steamed milk foam.",
                ingredients = "Espresso, Steamed milk foam",
                orderDescription = "250 ml",
                price = 6.0,
                isFav = false
            ),
            Coffee_Drinks(
                id = 3L,
                name = "Espresso",
                imageURL = R.drawable.cappuccino_small,
                description = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                ingredients = "Ground coffee, Water",
                orderDescription = "200 ml",
                price = 5.0,
                isFav = false
            ),
            Coffee_Drinks(
                id = 4L,
                name = "Espresso Macchiato",
                imageURL = R.drawable.cappuccino_small,
                description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                ingredients = "Espresso, Foamed milk",
                orderDescription = "300 ml",
                price = 6.5,
                isFav = false
            ),
            Coffee_Drinks(
                id = 5L,
                name = "Frappino",
                imageURL = R.drawable.cappuccino_small,
                description = "Frappino is a blended coffee drinks. It consists of coffee base, blended with ice and other various ingredients, usually topped with whipped cream.",
                ingredients = "Espresso, Cold milk, Sugar, Ice cubes, Irish Cream flavoured syrup, Whipped cream, Chocolate sauce",
                orderDescription = "400 ml",
                price = 6.0,
                isFav = false
            ),
            Coffee_Drinks(
                id = 6L,
                name = "Iced Mocha",
                imageURL= R.drawable.cappuccino_small,
                description = "Iced Mocha is a coffee beverage. It based on Espresso and chocolate syrup with cold milk, foam and whipped cream or ice cream.",
                ingredients = "Cold coffee, Milk, Chocolate syrup, Whipped cream, Ice cream",
                orderDescription = "400 ml",
                price = 6.5,
                isFav = false
            ),
            Coffee_Drinks(
                id = 7L,
                name = "Irish coffee",
                imageURL = R.drawable.cappuccino_small,
                description = "Irish coffee is a cocktail consisting of hot coffee, Irish whiskey, and sugar stirred, and topped with cream.",
                ingredients = "Irish whiskey, Hot strong brewed coffee, Heavy whipping cream, Sugar, Creme de menthe liqueur",
                orderDescription = "250 ml",
                price = 6.0,
                isFav = false),
            Coffee_Drinks(
                id = 8L,
                name = "Latte",
                imageURL = R.drawable.cappuccino_small,
                description = "A latte is a coffee drink made with espresso and steamed milk.",
                ingredients = "Espresso, Steamed milk",
                orderDescription = "300 ml",
                price = 6.0,
                isFav = false
            ),
            Coffee_Drinks(
                id = 9L,
                name = "Latte Macchiato",
                imageURL = R.drawable.cappuccino_small,
                description = "Latte Macchiato is a coffee beverage; the name literally means stained milk.",
                ingredients = "Espresso, Milk, Milk foam, Flavoured coffee syrup",
                orderDescription = "300 ml",
                price = 6.5,
                isFav = false
            ),
            Coffee_Drinks(
                id = 10L,
                name = "Mocha",
                imageURL = R.drawable.cappuccino_small,
                description = "A Mocha, also called mocaccino, is a chocolate-flavored variant of a Latte.",
                ingredients = "Espresso, Chocolate flavoring",
                orderDescription = "300 ml",
                price = 6.0,
                isFav = false
            )
        )
    }

}