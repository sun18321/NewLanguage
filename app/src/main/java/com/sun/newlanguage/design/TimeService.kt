package com.sun.newlanguage.design

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*
import kotlin.concurrent.timerTask

class TimeService : Service() {
    private var mCurrentSeconds = 0
    private var mPause = false
    private val mTimer = Timer()
    private val mTimerTask = timerTask {
        if (!mPause) {
            mCurrentSeconds++
            Log.d("time", "current time:$mCurrentSeconds")
        } else {
            Log.d("time","status is pause")
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        mTimer.schedule(mTimerTask, 0, 1000)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val flag = intent?.getStringExtra("flag")
        if (flag == "background") {
            mPause = true
        }else if (flag == "foreground") {
            mPause = false
        }


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
