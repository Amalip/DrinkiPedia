package com.amalip.cocktailtestapp.data.repoImpl

import android.content.Context
import com.amalip.cocktailtestapp.application.utils.Either
import com.amalip.cocktailtestapp.application.utils.Failure
import com.amalip.cocktailtestapp.application.utils.Repository
import com.amalip.cocktailtestapp.data.remote.CocktailApi
import com.amalip.cocktailtestapp.data.remote.CocktailService
import com.amalip.cocktailtestapp.domain.models.Cocktail
import com.amalip.cocktailtestapp.domain.models.Drink
import com.amalip.cocktailtestapp.domain.repository.CocktailRepository

class CocktailImpl(private val context: Context, private val service: CocktailService) :
    Repository(), CocktailRepository {


    override fun getCocktails(filter: String): Either<Failure, Drink> {
        return request(service.getCocktails(filter), { it }, Drink())
    }
}