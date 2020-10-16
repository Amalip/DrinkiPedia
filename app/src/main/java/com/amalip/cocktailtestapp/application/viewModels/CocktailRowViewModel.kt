package com.amalip.cocktailtestapp.application.viewModels

import androidx.lifecycle.MutableLiveData
import com.amalip.cocktailtestapp.application.utils.RecyclerViewViewModel
import com.amalip.cocktailtestapp.domain.models.Cocktail

class CocktailRowViewModel : RecyclerViewViewModel() {

    val img = MutableLiveData("")
    val name = MutableLiveData("")
    val desc = MutableLiveData("")


    fun setData(cocktail: Cocktail) {
        img.postValue(cocktail.img)
        name.postValue(cocktail.name)
        desc.postValue(cocktail.desc)
    }

}