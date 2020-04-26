package com.example.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.db.repository.ShoeRepository

/**
 * @author: cgy
 * @date: 2020/4/26 9:53
 * @description:
 */
class FavouriteModel constructor(shoeRepository: ShoeRepository, userId: Long) : ViewModel() {

    //鞋子集合的观察类
    val shoes : LiveData<List<Shoe>> = shoeRepository.getShoesByUserId(userId)
}