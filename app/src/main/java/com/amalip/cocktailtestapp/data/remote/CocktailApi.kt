package com.amalip.cocktailtestapp.data.remote

import com.amalip.cocktailtestapp.domain.models.Drink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("search.php")
    fun getCocktails(@Query("s") filter: String): Call<Drink>

}