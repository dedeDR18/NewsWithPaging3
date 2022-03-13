package com.example.newswithpaging3.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newswithpaging3.R

object BindingUtils {
    @JvmStatic
    @BindingAdapter("glideImage")
    fun setImage(imageView: ImageView, imgUrl:String?){
        imgUrl?.let {
            Glide.with(imageView.context)
                .load(it)
                .fitCenter()
                .apply(RequestOptions().override(300, 300))
                .placeholder(R.drawable.ic_image)
                .into(imageView)
        }
    }
}