package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sun.newlanguage.R
import com.sun.newlanguage.model.DataModel
import kotlinx.android.synthetic.main.activity_model.*
import kotlinx.android.synthetic.main.text.*

class ModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)


        val model = ViewModelProviders.of(this).get(DataModel::class.java)
        tv_name.text = model.getName()
        model.getData().observe(this, Observer {
            tv_times.text = it.toString()
        })

        button_add.setOnClickListener {
            model.addTimes()
        }

        button_big_add.setOnClickListener {
            model.getData().postValue(99999)
        }

        model.getSecondObserve().observe(this, Observer {
            tv_observe_top.text = it
        })

    }
}
