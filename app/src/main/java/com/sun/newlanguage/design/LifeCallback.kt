package com.sun.newlanguage.design

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.util.Log

abstract class LifeCallback : Application.ActivityLifecycleCallbacks {
    private var mActivityCount = 0
    private var mForeground = false
    private val mHandler = Handler()
    private var mLastCallback = 0L

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {
        Log.d("life", "activity start")

        mActivityCount++
        if (mActivityCount == 1) {
            Log.d("stage", "foreground")
            mForeground = true

            callbackAppStatus()
        }

    }

    override fun onActivityDestroyed(activity: Activity) {
//        if (mActivityCount == 0) {
//            onAppDestroy()
//        }

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {
        Log.d("life", "activity stop")

        mActivityCount--
        if (mActivityCount == 0) {
            Log.d("stage", "background")
            mForeground = false

            callbackAppStatus()
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityResumed(activity: Activity) {

    }


    private fun callbackAppStatus() {
        val current = System.currentTimeMillis()
        val space = current - mLastCallback
        mLastCallback = current

        Log.d("life_callback","callback status space:$space")

        mHandler.removeCallbacksAndMessages(null)
        mHandler.postDelayed({
            if (mForeground) {
                onAppForeground()
            } else {
                onAppBackground()
            }
        }, 300)
    }


    abstract fun onAppForeground()

    abstract fun onAppBackground()

    abstract fun onAppDestroy()

}