package com.sun.newlanguage.design

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView
import com.sun.newlanguage.util.Constant

class SendText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"send text on touch event ")

        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"send text dispatch ")

        return super.dispatchTouchEvent(event)
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        Log.d(Constant.send_event,"send text on touch")

        super.setOnTouchListener(l)
    }
}