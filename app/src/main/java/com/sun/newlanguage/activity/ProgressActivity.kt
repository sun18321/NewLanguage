package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_progress.*
import kotlin.math.log

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        Log.d("size", "create height:" + view.height)

        view.startProgress()
        circle.startProgress()

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        Log.d("size", "window size height:" + view.height + "--width:" + view.width)


    }
}
