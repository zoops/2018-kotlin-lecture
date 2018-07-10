package com.moberan.zoops.rndhub

import android.graphics.drawable.Drawable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl", "error")
fun loadImage(imageView: ImageView, url: String?, errorDrawable: Drawable?) {
    Glide.with(imageView.getContext()).load(url).centerCrop().placeholder(errorDrawable).dontAnimate().into(imageView)
}

