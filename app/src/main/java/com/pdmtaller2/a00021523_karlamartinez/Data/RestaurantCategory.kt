package com.pdmtaller2.a00021523_karlamartinez.Data

fun categoriasRestaurante(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
    return restaurants
        .flatMap { rest -> rest.categorias.map { categoria -> categoria to rest } }
        .groupBy({it.first}, {it.second})
}