package com.sun.newlanguage.design

import com.sun.newlanguage.util.Test

class KotlinListener {
    private var key = "secret"
    private val num = 6

    private lateinit var mListener: (String,Int) -> Unit

    fun inputData(s:String) {
        key += s
    }

    fun setListener(listener: (String,Int) -> Unit){
        mListener = listener
        mListener(key,num)
    }


    fun setStringListener(listener: (String) -> Unit){
        listener(key)
    }

    fun setStateListener(listener:StateListener){
        listener.onSuccess(1,"123")

    }

    fun setNullListener(i: Int, listener: () -> Unit) {
        listener()
    }
}