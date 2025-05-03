package com.pdmtaller2.a00021523_karlamartinez.Data

import com.pdmtaller2.a00021523_karlamartinez.R

val restaurant = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Push",
        categorias = listOf("Comida Italiana", "Fast Food"),
        descripcion = "La pizza deliciosita",
        imagen = R.drawable.pizza_logo,
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Chipotle",
                descripcion = "Pizza chipotle extra deliciosa",
                imagen = R.drawable.pizza
            ),
            Dish(
                id = 2,
                name = "Pizza Margarita",
                descripcion = "Clasica con tomate, mozzarella y albahaca",
                imagen = R.drawable.pizza
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Sushi Pop",
        categorias = listOf("Comida Japonesa", "Fast Food"),
        descripcion = "El suchi deliciosito",
        imagen = R.drawable.sushi_logo,
        menu = listOf(
            Dish(
                id = 1,
                name = "Sushi roll",
                descripcion = "Arroz con pescado fresco",
                imagen = R.drawable.sushi
            ),
            Dish(
                id = 2,
                name = "Sashimi",
                descripcion = "Lonja de pescado crudo",
                imagen = R.drawable.sushi
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "La Taquezona",
        categorias = listOf("Comida Mexicana", "Fast Food"),
        descripcion = "El taquito delicioso",
        imagen = R.drawable.tacos_logo,
        menu = listOf(
            Dish(
                id = 1,
                name = "Taco al pastor",
                descripcion = "Con carne de cerdos",
                imagen = R.drawable.tacos
            ),
            Dish(
                id = 2,
                name = "Quesadilla",
                descripcion = "Queso derretido",
                imagen = R.drawable.tacos
            )
        )
    )
)