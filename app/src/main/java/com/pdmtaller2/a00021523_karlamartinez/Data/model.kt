package com.pdmtaller2.a00021523_karlamartinez.Data

data class Restaurant(
    val id: Int,
    val name: String,
    val categorias: List<String>,
    val descripcion: String,
    val imagen: Int,
    val menu: List<Dish>
)

data class Dish(
    val id: Int,
    val name: String,
    val descripcion: String,
    val imagen: Int? = null
)

