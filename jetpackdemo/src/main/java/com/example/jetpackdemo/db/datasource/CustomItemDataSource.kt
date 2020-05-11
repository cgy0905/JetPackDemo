package com.example.jetpackdemo.db.datasource

import androidx.paging.ItemKeyedDataSource
import com.example.jetpackdemo.db.data.Shoe

/**
 * @author: cgy
 * @date: 2020/5/11 10:46
 * @description: 自定义ItemKeyedDataSource资源
 * 演示Page库的时候使用
 */
class CustomItemDataSource : ItemKeyedDataSource<Int, Shoe>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Shoe>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Shoe>) {
        TODO("Not yet implemented")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Shoe>) {
        TODO("Not yet implemented")
    }

    override fun getKey(item: Shoe): Int {
        TODO("Not yet implemented")
    }
}