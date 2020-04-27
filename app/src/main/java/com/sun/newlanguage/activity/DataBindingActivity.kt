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
//            Log.d("data_binding", "receive data change size:${it.size}--0:${it[0]}")
//            adapter.submitList(null)
//            Log.d("data_binding","hashcode:${it.hashCode()}")
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        }


        val oldList = mutableListOf<NewAdapterBean>()
        for(index in 0..5){
            oldList.add(NewAdapterBean("jordan-$index", index))
        }
        mLiveList.postValue(oldList)

//        adapter.submitList(list)

        GlobalScope.launch(Dispatchers.Main) {
            delay(5000)
            Log.d("data_binding","modify list data")
//
            val newList = mutableListOf<NewAdapterBean>()
//            newList.addAll(list)
//
//            newList[0].name = "普京"
//            newList[0].money = 888
//            newList.add(NewAdapterBean("特朗普", 9999))


            for (index in 0..5) {
                newList.add(oldList[index])
            }

            val copy = oldList[0].copy()
            Log.d("data_binding","before copy:${oldList[0].hashCode()}----after copy:${copy.hashCode()}")

            for(index in 0..5){
//                newList.add(NewAdapterBean("特朗普-$index", index))
                newList[index].money = 7777
            }

            mLiveList.postValue(newList)
        }
    }
}
