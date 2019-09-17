package com.sun.newlanguage.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sun.newlanguage.fragment.FirstFragment


class MyPagerAdapter(private val mContext: FragmentActivity) : FragmentStateAdapter(mContext) {

    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        return FirstFragment(mContext)
    }


}