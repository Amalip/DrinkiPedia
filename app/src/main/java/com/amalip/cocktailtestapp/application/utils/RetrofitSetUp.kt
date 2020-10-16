package com.amalip.cocktailtestapp.application.utils

import com.amalip.cocktailtestapp.data.remote.CocktailApi
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitSetUp {

    private val moshiAdapter =
        Moshi.Builder().build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshiAdapter))

    val cocktailApi: CocktailApi by lazy {
        retrofit.baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")

        return@lazy retrofit.build().create(CocktailApi::class.java)
    }

}