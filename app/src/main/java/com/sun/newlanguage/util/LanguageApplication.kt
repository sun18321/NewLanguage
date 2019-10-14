package com.sun.newlanguage.util

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class LanguageApplication:Application() {
    companion object{
        var CONTEXT: Context by Delegates.notNull()

    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
    }
}