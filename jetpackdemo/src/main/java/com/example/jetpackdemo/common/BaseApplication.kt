package com.example.jetpackdemo.common

import android.app.Application
import android.content.Context

/**
 * @author: cgy
 * @date: 2020/4/24 15:06
 * @description:
 */
open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context : Context
    }
}