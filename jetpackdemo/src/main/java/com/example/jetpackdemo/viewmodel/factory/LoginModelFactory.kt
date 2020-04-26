package com.example.jetpackdemo.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdemo.db.repository.UserRepository
import com.example.jetpackdemo.viewmodel.LoginModel

/**
 * @author: cgy
 * @date: 2020/4/24 18:02
 * @description:
 */
class LoginModelFactory(
    private val repository: UserRepository,
    private val context: Context
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginModel(repository) as T
    }
}