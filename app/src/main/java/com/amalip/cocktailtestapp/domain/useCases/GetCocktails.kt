package com.amalip.cocktailtestapp.domain.useCases

import com.amalip.cocktailtestapp.application.utils.Either
import com.amalip.cocktailtestapp.application.utils.Failure
import com.amalip.cocktailtestapp.application.utils.UseCase
import com.amalip.cocktailtestapp.data.repoImpl.CocktailImpl
import com.amalip.cocktailtestapp.domain.models.Drink

class GetCocktails (private val repo: CocktailImpl) :
    UseCase<Drink, GetCocktails.Params>() {

    override suspend fun run(params: Params): Either<Failure, Drink> =
        repo.getCocktails(params.filter)

    data class Params(val filter: String)

}