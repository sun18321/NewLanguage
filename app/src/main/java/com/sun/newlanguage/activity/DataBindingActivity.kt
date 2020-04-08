package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import com.sun.newlanguage.R
import com.sun.newlanguage.adapter.NewAdapter
import com.sun.newlanguage.bean.NewAdapterBean
import com.sun.newlanguage.databinding.ActivityDataBindingBinding
import kotlinx.android.synthetic.main.activity_data_binding.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DataBindingActivity : AppCompatActivity() {
    private val mLiveList = MutableLiveData<List<NewAdapterBean>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_binding)

        val binding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this, R.layout.activity_data_binding)
//        binding.image = "https://bsaccount-1256119282.cos.ap-chengdu.myqcloud.com/0e9570ce1cdd4a93af866634333755f5.png"

        val adapter = NewAdapter()
        binding.recycler.adapter = adapter
        mLiveList.observe(this){
            Log.d("data_binding", "receive data change size:${it.size}")
            adapter.submitList(it)
        }


        val list = mutableListOf<NewAdapterBean>()
        for(index in 0..5){
            list.add(NewAdapterBean("jordan-$index", index))
        }
        mLiveList.postValue(list)

//        adapter.submitList(list)

        GlobalScope.launch(Dispatchers.Main) {
            delay(5000)
            Log.d("data_binding","modify list data")

            list[0].name = "普京"
            list[0].money = 888
            list.add(NewAdapterBean("特朗普", 9999))

            mLiveList.postValue(list)
        }
    }
}
