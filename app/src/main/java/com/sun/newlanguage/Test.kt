package com.sun.newlanguage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap


class Test :ViewModel(){

    val partModel = MutableLiveData<String>().apply {
       value = ALL
    }



    private fun test() {

    }

    companion object{
        private const val ALL = "all"
    }

}
