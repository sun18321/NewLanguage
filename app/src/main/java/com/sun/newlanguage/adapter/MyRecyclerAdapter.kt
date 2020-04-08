package com.sun.newlanguage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.text.view.*
import kotlinx.android.synthetic.main.viewpager_item.view.*

class MyRecyclerAdapter(private val mContext: Context):RecyclerView.Adapter<MyRecyclerAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.text, parent, false)
        return MyHolder(view)

    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.tv.text = "这是一大堆的信息:$position"
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}