package com.sun.newlanguage

import android.app.Application
import android.content.Intent
import android.util.Log
import com.sun.newlanguage.design.LifeCallback
import com.sun.newlanguage.design.TimeService

class NewApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object :LifeCallback(){
            override fun onAppForeground() {
                Log.d("life_callback","application receive foreground")


                startService(Intent(applicationContext,TimeService::class.java).putExtra("flag","foreground"))
            }

            override fun onAppBackground() {
                Log.d("life_callback","application receive background")

                startService(Intent(applicationContext,TimeService::class.java).putExtra("flag","background"))
            }

            override fun onAppDestroy() {
                Log.d("life_callback","application receive destroy")
            }

        })

    }
}