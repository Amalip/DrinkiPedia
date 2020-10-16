package com.amalip.cocktailtestapp

import android.app.Application
import com.amalip.cocktailtestapp.application.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CocktailTestApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CocktailTestApp)
            modules(
                listOf(
                    viewModelModules,
                    useCases,
                    repositories,
                    services,
                    objModule
                )
            )
        }
    }

}