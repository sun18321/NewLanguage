package com.sun.newlanguage

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class JavaTest : FrameLayout, JavaInterface {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun one() {
        Thread(Runnable { }).start()
    }

    override fun two() {

    }
}
