package com.amalip.cocktailtestapp.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Drink(@Json(name = "drinks") val cocktails: List<Cocktail>? = null)