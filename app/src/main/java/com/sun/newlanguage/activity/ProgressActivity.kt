package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.ProgressAdapter
import kotlinx.android.synthetic.main.activity_perogress.*

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perogress)


        val list = mutableListOf<Int>()
        for (index in 0..8) {
            list.add(0)
        }

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.setHasFixedSize(true)
//        recycler.isNestedScrollingEnabled = false
        (recycler.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        val adapter = ProgressAdapter(list)
        recycler.adapter = adapter

        button_modify.setOnClickListener {
            if (list.isNotEmpty()) {
                list[0] = 50
                adapter.notifyItemChanged(0)
            }
        }

        button_delete.setOnClickListener {
            if (list.isNotEmpty()) {
                list.removeAt(list.size - 1)
                adapter.notifyItemRemoved(list.size)
            }
        }
    }
}
