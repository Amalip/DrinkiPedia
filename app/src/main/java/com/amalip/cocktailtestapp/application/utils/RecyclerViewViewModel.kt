package com.amalip.cocktailtestapp.application.utils

import androidx.lifecycle.ViewModel

abstract class RecyclerViewViewModel : ViewModel() {

    var eventHandler: RecyclerViewEventHandler? = null

}

interface RecyclerViewEventHandler