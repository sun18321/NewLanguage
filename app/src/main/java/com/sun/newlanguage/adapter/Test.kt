package com.sun.newlanguage.adapter

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.sun.newlanguage.fragment.FirstFragment

class Test {
    private val mContext: Context? = null

    private fun test() {
        val fragment = FirstFragment(mContext!!)
        val bundle = Bundle()
        fragment.arguments = bundle

    }
}
