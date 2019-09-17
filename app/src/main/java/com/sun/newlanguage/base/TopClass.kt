package com.sun.newlanguage.base

import com.sun.newlanguage.view.JavaFragment

abstract class TopClass {
    abstract fun topMethod()

    protected fun showMethod() {
        JavaFragment.instance

    }
}
