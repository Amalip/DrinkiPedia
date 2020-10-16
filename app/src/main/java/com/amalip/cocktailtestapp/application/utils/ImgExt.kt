package com.amalip.cocktailtestapp.application.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.CircleCropTransformation


@BindingAdapter("app:circularImageUrl")
fun ImageView.loadCircularImageByURL(url: String) = this.load(url) {
    crossfade(true)
    crossfade(100)
    scaleType = ImageView.ScaleType.FIT_XY
    transformations(CircleCropTransformation())
}