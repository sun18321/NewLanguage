package com.sun.newlanguage.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_one.view.*
import kotlinx.android.synthetic.main.fragment_one.view.recycler

class FirstFragment(private val mContext: Context) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(mContext).inflate(R.layout.fragment_one, container, false)
        view.recycler.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        view.recycler.adapter = MyRecyclerAdapter(mContext)
        return view
    }
}