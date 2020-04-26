package com.example.jetpackdemo.common.listener

import android.text.Editable
import android.text.TextWatcher

/**
 * @author: cgy
 * @date: 2020/4/24 16:08
 * @description:
 */
open class SimpleWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}