package com.amalip.cocktailtestapp.application.di

import com.amalip.cocktailtestapp.application.adapter.CocktailsAdapter
import com.amalip.cocktailtestapp.application.utils.RetrofitSetUp
import com.amalip.cocktailtestapp.application.viewModels.CocktailRowViewModel
import com.amalip.cocktailtestapp.application.viewModels.MainViewModel
import com.amalip.cocktailtestapp.data.remote.CocktailService
import com.amalip.cocktailtestapp.data.repoImpl.CocktailImpl
import com.amalip.cocktailtestapp.domain.useCases.GetCocktails
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {

    viewModel { MainViewModel(get()) }

    viewModel { CocktailRowViewModel() }

}

val useCases = module {

    single { GetCocktails(get()) }

}

val repositories = module {

    single { CocktailImpl(androidContext(), get()) }

}

val services = module {


    single { CocktailService(get()) }

}

val objModule = module {

    factory { RetrofitSetUp }

    factory { CocktailsAdapter() }

}