package com.sun.newlanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sun.newlanguage.bean.JavaBean
import com.sun.newlanguage.bean.KotlinBean
import com.sun.newlanguage.bean.Msg
import com.sun.newlanguage.bean.TestBean
import com.sun.newlanguage.design.JavaGson
import com.sun.newlanguage.design.KotlinListener
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val list = arrayListOf<Msg>()
        val bean = KotlinBean(1, list)
        bean.code = 1


        val kot = KotlinListener()
        kot.inputData(":data")
        kot.setListener { s, i ->

        }

        KotlinListener().setListener { s, i ->

        }


        KotlinListener().setStringListener {

        }

        KotlinListener().setNullListener(5,{})


        val json = "{\"name\":\"bryant\"}"
        var testBean = Gson().fromJson(json, TestBean::class.java)

        Log.d("test","name:" + testBean.name + "age" + testBean.age)

        val getBean = JavaGson().bean
        Log.d("test","java name:" + getBean.name + "age" + getBean.age)


        val data = "我就是数据源"
        val file = File(getExternalFilesDir("cao" +
                "" +
                "" +
                ""),"i am mp3.log")
//        if (!file.exists()) {
            Log.d("file", "file not exist")
            val outputStream = FileOutputStream(file)
            val bufferedOutputStream = BufferedOutputStream(outputStream)
            bufferedOutputStream.write(data.toByteArray(), 0, data.length)
            bufferedOutputStream.flush()
            bufferedOutputStream.close()
//        } else {
//            Log.d("file", "file exist")
//
//        }


        val externalCacheDir = getExternalFilesDir("study")
        val newFile = File(externalCacheDir, "aaa.txt")
        try {
            val stream = FileOutputStream(newFile)
            val bufferedOutputStream = BufferedOutputStream(stream)
            bufferedOutputStream.write(data.toByteArray(), 0, data.length)
            bufferedOutputStream.flush()
            bufferedOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
}