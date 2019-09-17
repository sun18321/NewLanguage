package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.sun.newlanguage.R
import com.sun.newlanguage.util.Constant

class SendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"activity on touch ")

        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"activity dispatch ")

        return super.dispatchTouchEvent(ev)
    }

}
