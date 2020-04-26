package com.example.jetpackdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.db.repository.UserRepository
import com.example.jetpackdemo.viewmodel.RegisterModel

/**
 * @author: cgy
 * @date: 2020/4/24 17:38
 * @description:
 */
class RegisterModelFactory (
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterModel(repository) as T
    }
}