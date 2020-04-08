package com.sun.newlanguage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sun.newlanguage.base.BaseBindingHolder
import com.sun.newlanguage.bean.BeanDiff
import com.sun.newlanguage.bean.NewAdapterBean
import com.sun.newlanguage.databinding.NewAdapterBinding

class NewAdapter:ListAdapter<NewAdapterBean,BaseBindingHolder>(BeanDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingHolder {
        return BaseBindingHolder(NewAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BaseBindingHolder, position: Int) {

        val item = getItem(position)
        val binding = (holder.getBinding() as NewAdapterBinding)
        binding.viewBean = item

    }
}