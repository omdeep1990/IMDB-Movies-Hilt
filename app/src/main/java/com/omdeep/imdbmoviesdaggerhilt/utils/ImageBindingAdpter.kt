package com.omdeep.imdbmoviesdaggerhilt.utils

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.omdeep.imdbmoviesdaggerhilt.R

@BindingAdapter("setImage")
fun ShapeableImageView.setImage(url: String?) {
    Glide.with(this.context).load(url).placeholder(R.drawable.ic_launcher_foreground).into(this)
}