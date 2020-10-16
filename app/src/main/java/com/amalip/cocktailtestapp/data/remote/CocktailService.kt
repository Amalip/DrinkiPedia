package com.amalip.cocktailtestapp.data.remote

import com.amalip.cocktailtestapp.application.utils.RetrofitSetUp

class CocktailService(private val retrofit: RetrofitSetUp): CocktailApi {

    override fun getCocktails(filter: String) = retrofit.cocktailApi.getCocktails(filter)

}