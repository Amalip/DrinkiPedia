package com.amalip.cocktailtestapp.application.viewModels

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.SearchView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amalip.cocktailtestapp.application.utils.Failure
import com.amalip.cocktailtestapp.domain.models.Cocktail
import com.amalip.cocktailtestapp.domain.models.Drink
import com.amalip.cocktailtestapp.domain.useCases.GetCocktails

class MainViewModel(private val getCocktails: GetCocktails): ViewModel() {

    val filter = MutableLiveData("margarita")
    val cocktails = MutableLiveData(mutableListOf<CocktailRowViewModel>())
    val emptyViewVisibility = MutableLiveData(GONE)
    val progressVisibility = MutableLiveData(GONE)
    val failure = MutableLiveData<Failure>()

    fun getCocktailsByFilter() {
        progressVisibility.postValue(VISIBLE)
        getCocktails.execute(
            { it.either(::handleFailure, ::handleGetCocktails) },
            GetCocktails.Params(filter.value ?: "margarita")
        )
    }

    val queryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            return true
        }

        override fun onQueryTextSubmit(newQuery: String): Boolean {
            filter.postValue(newQuery)
            return true
        }
    }

    private fun handleGetCocktails(drinks: Drink) {
        progressVisibility.postValue(GONE)
        if (drinks.cocktails.isNullOrEmpty()) {
            emptyViewVisibility.postValue(VISIBLE)
            return
        }


        val list = mutableListOf<CocktailRowViewModel>()

        drinks.cocktails.forEach {
            val row = CocktailRowViewModel()

            row.setData(it)

            list.add(row)
        }

        this.cocktails.postValue(list)

        emptyViewVisibility.postValue(GONE)
    }


    private fun handleFailure(failure: Failure) {
        progressVisibility.postValue(GONE)
        this.failure.postValue(failure)
    }

}