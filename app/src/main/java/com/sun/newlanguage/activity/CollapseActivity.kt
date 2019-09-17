package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.MyPagerAdapter
import com.sun.newlanguage.fragment.FirstFragment
import kotlinx.android.synthetic.main.activity_collapse.*

class CollapseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapse)

        init()
    }

    private fun init() {

        viewpager.adapter = MyPagerAdapter( this)




    }
}
