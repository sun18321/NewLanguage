package com.sun.newlanguage.bean

data class BaseNetBean<out T>(val errorCode: Int, val errorMsg: String, val data: T)
