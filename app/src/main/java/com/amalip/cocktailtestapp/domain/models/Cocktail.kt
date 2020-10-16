package com.amalip.cocktailtestapp.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cocktail(
    @Json(name = "strDrinkThumb") val img: String,
    @Json(name = "strDrink") val name: String,
    @Json(name = "strInstructions") val desc: String
)