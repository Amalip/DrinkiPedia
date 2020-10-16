package com.amalip.cocktailtestapp.application.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.amalip.cocktailtestapp.R
import com.amalip.cocktailtestapp.application.utils.BaseAdapter
import com.amalip.cocktailtestapp.application.utils.RecyclerViewViewModel
import com.amalip.cocktailtestapp.application.viewModels.CocktailRowViewModel

class CocktailsAdapter : BaseAdapter<CocktailRowViewModel>(diffCallback = object :
    DiffUtil.ItemCallback<CocktailRowViewModel>() {
    override fun areItemsTheSame(oldItem: CocktailRowViewModel, newItem: CocktailRowViewModel) =
        oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: CocktailRowViewModel, newItem: CocktailRowViewModel) =
        oldItem == newItem
}) {
    override fun getLayoutIdForPosition(position: Int) = R.layout.cocktail_row
}