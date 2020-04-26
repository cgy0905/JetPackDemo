package com.example.jetpackdemo.viewmodel

import android.content.Context
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.db.RepositoryProvider
import com.example.jetpackdemo.db.repository.FavouriteShoeRepository
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.db.repository.UserRepository
import com.example.jetpackdemo.utils.AppPrefsUtils
import com.example.jetpackdemo.viewmodel.factory.FavouriteModelFactory
import com.example.jetpackdemo.viewmodel.factory.LoginModelFactory
import com.example.jetpackdemo.viewmodel.factory.RegisterModelFactory

/**
 * @author: cgy
 * @date: 2020/4/24 17:37
 * @description:
 */
object CustomViewModelProvider {

    fun providerRegisterModel(context: Context) : RegisterModelFactory {
        val repository : UserRepository = RepositoryProvider.providerUserRepository(context)
        return RegisterModelFactory(repository)
    }

    fun providerLoginModel(context: Context) : LoginModelFactory {
        val repository : UserRepository = RepositoryProvider.providerUserRepository(context)
        return LoginModelFactory(repository, context)
    }

    fun providerFavouriteModel(context: Context) : FavouriteModelFactory {
        val repository : ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        val userId : Long = AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        return FavouriteModelFactory(repository, userId)
    }
}