package com.sun.newlanguage.model

import androidx.lifecycle.*
import androidx.lifecycle.Transformations.map

class DataModel : ViewModel() {
    private val observeData = MutableLiveData<Int>()

    private val secondObserve = map(observeData) {"i am observe top:$it"}

    private val test = MutableLiveData<MutableLiveData<String>>()


    private val thirdObserve = test.switchMap {
        it
    }


    private var times = 0

    public fun getName() = "i am data"

    public fun getVersion() = "1.0.0"

    public fun getTimes() = times


    public fun addTimes() {
        times++
        observeData.value = times
    }

    public fun getData() = observeData

    public fun getSecondObserve() = secondObserve

    private fun testFun() {
        test.value?.value = "123"
    }


}