package com.example.jetpackdemo.db

import android.content.Context
import com.example.jetpackdemo.db.repository.FavouriteShoeRepository
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.db.repository.UserRepository

/**
 * @author: cgy
 * @date: 2020/4/24 17:16
 * @description:
 */
object RepositoryProvider {

    /**
     * 得到用户仓库
     */
    fun providerUserRepository(context: Context) : UserRepository {
        return UserRepository.getInstance(AppDataBase.getInstance(context).userDao())
    }

    /**
     * 得到鞋的仓库
     */
    fun providerShoeRepository(context: Context) : ShoeRepository {
        return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }

    /**
     * 得到收藏记录的仓库
     */
    fun providerFavouriteShoeRepository(context: Context) : FavouriteShoeRepository {
        return FavouriteShoeRepository.getInstance(AppDataBase.getInstance(context).favouriteShoeDao())
    }
}