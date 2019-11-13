package com.sun.newlanguage.bean


sealed class ResultBean <out T : Any>{

    data class Success<out T:Any>(val data:T):ResultBean<T>()

    data class Error(val exception:Exception):ResultBean<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}