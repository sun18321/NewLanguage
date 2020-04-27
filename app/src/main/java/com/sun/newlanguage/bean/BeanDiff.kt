package com.sun.newlanguage.bean

import android.util.Log
import androidx.recyclerview.widget.DiffUtil

class BeanDiff:DiffUtil.ItemCallback<NewAdapterBean>(){

    override fun areItemsTheSame(oldItem: NewAdapterBean, newItem: NewAdapterBean): Boolean {
        val itemSame = oldItem.name == newItem.name
        Log.d("data_binding","old:$oldItem---new:$newItem--item same:$itemSame")
        return itemSame
    }

    override fun areContentsTheSame(oldItem: NewAdapterBean, newItem: NewAdapterBean): Boolean {
        val contentSame = oldItem.name == newItem.name && oldItem.money == oldItem.money
        Log.d("data_binding", "old:$oldItem---new:$newItem--content same:$contentSame")
        return contentSame
    }

}