package com.example.jetpackdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.viewmodel.FavouriteModel

/**
 * @author: cgy
 * @date: 2020/4/26 9:52
 * @description:
 */
class FavouriteModelFactory (private val repository: ShoeRepository, private val userId : Long) :
 ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavouriteModel(repository, userId) as T
    }
}