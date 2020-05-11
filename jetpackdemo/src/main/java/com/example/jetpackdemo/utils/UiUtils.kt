package com.example.jetpackdemo.utils

import android.content.Context

/**
 * @author: cgy
 * @date: 2020/5/11 11:38
 * @description:
 */
object UiUtils {

    fun dp2px(context: Context, dpValue : Float) : Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}