package com.example.jetpackdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdemo.db.repository.FavouriteShoeRepository
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.viewmodel.DetailModel

/**
 * @author: cgy
 * @date: 2020/5/11 13:37
 * @description:
 */
class FavouriteShoeModelFactory(
    private val shoeRepository: ShoeRepository,
    private val favouriteShoeRepository: FavouriteShoeRepository,
    private val shoeId: Long,
    private val userId: Long
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailModel(shoeRepository, favouriteShoeRepository, shoeId, userId) as T
    }
}