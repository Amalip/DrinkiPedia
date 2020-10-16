package com.amalip.cocktailtestapp.domain.repository

import com.amalip.cocktailtestapp.application.utils.Either
import com.amalip.cocktailtestapp.application.utils.Failure
import com.amalip.cocktailtestapp.domain.models.Drink

interface CocktailRepository {

    fun getCocktails(filter: String): Either<Failure, Drink>

}