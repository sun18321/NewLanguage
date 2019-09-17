package com.sun.newlanguage.util

import com.sun.newlanguage.bean.JavaBean

class KotlinUtil {
    var test = "test"


    companion object{
        val FIRST_CONST = 1223

        fun getNum():Int{
            return 5
        }
    }

     fun nonStaticGet():Int{
        return 1000
    }
}