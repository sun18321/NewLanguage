package com.sun.newlanguage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sun.newlanguage.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {
    private val TAG = "thread"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        Log.d(TAG,"activity thread:${Thread.currentThread().name}---id:${Thread.currentThread().id}")


        button_default.setOnClickListener {
            GlobalScope.launch {
                Log.d(TAG,"default thread:${Thread.currentThread().name}---id:${Thread.currentThread().id}")
                tv_show.text = "default"
            }
        }

        button_main.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                Log.d(TAG,"main thread:${Thread.currentThread().name}---id:${Thread.currentThread().id}")
                tv_show.text = "main"
            }
        }

        button_io.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                Log.d(TAG,"io thread:${Thread.currentThread().name}---id:${Thread.currentThread().id}")
                withContext(Dispatchers.Main){
                    Log.d(TAG,"io inner thread:${Thread.currentThread().name}---id:${Thread.currentThread().id}")
                    tv_show.text = "io"
                }
            }
        }
    }
}
