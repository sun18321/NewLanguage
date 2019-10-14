package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_add_view.*

class AddViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val tv = TextView(this)
        tv.text = "i am add"
        tv.textSize = 20f

        button_add.setOnClickListener {
            rel_add.addView(tv)
            Log.d("size","add size:${tv.height}")
        }

        button_big.setOnClickListener {
            tv.textSize = 60f
            Log.d("size","big size:${tv.height}")
        }
    }
}
