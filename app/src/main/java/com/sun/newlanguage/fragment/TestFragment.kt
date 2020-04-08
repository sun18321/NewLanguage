package com.sun.newlanguage.fragment

import androidx.fragment.app.Fragment

class TestFragment internal constructor(a: Int) : Fragment() {
    private var mNum = 0

    init {
        mNum = a

    }

}
