package com.sun.newlanguage.design

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout
import com.sun.newlanguage.util.Constant

class SendLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"send layout on touch ")

        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"send layout intercept")

        return false
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(Constant.send_event,"send layout dispatch ")

        return super.dispatchTouchEvent(ev)
    }
}