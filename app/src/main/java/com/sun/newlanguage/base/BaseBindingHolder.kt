package com.sun.newlanguage.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseBindingHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

    fun getBinding() = binding
}
