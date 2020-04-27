package com.sun.newlanguage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.item_progress.view.*

class ProgressAdapter(private val mData: MutableList<Int>):RecyclerView.Adapter<BaseHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return BaseHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_progress,parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.itemView.progress.progress = mData[position]
    }
}