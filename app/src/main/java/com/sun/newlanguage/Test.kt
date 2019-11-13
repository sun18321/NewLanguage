package com.sun.newlanguage

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


class Test {
    private fun test() {
        val client = OkHttpClient.Builder().connectTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS).build()
        val request = Request.Builder().url("123").get().build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

            }

        })

    }

}
