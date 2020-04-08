package com.sun.newlanguage.bean

import androidx.recyclerview.widget.DiffUtil

class BeanDiff:DiffUtil.ItemCallback<NewAdapterBean>(){
    override fun areItemsTheSame(oldItem: NewAdapterBean, newItem: NewAdapterBean): Boolean {
        return oldItem.name == newItem.name && oldItem.money == newItem.money
    }

    override fun areContentsTheSame(oldItem: NewAdapterBean, newItem: NewAdapterBean): Boolean {
        return oldItem == newItem
    }

}