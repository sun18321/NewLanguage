package com.sun.newlanguage

import android.os.Handler
import android.os.Message

import java.lang.reflect.Method

class JavaTest {

    private fun test() {
        try {
            val name = Class.forName("123")
            val method = name.getDeclaredMethod("start", Int::class.javaPrimitiveType)
            val o = method.invoke(name.newInstance(), 2)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
