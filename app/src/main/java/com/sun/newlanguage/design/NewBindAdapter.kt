package com.sun.newlanguage.design

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["urlForImage", "testInt", "testString", "testBoolean","nextString"])
fun bindUrlForImage(image: ImageView, url: String?, one: Int, two: String, three: Boolean,four:String) {
    Log.d("binding","one:$one---two:$two----three:$three---four:$four")

    if (!url.isNullOrEmpty()) {
        Glide.with(image.context).load(url).into(image)
    }
}