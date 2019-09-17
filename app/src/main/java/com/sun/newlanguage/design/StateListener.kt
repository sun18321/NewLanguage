package com.sun.newlanguage.design

interface StateListener {
    fun onSuccess(code: Int, message: String)

    fun onFailed(code: Int,msg:String)

    fun onError(code: Int)

}