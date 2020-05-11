package com.example.jetpackdemo.db.datasource

import androidx.paging.DataSource
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.db.repository.ShoeRepository

/**
 * @author: cgy
 * @date: 2020/5/11 11:00
 * @description: 构建CustomPageDataSource的工厂
 */
class CustomPageDataSourceFactory (private val shoeRepository: ShoeRepository) : DataSource.Factory<Int, Shoe>() {
    override fun create(): DataSource<Int, Shoe> {
        return CustomPageDataSource(shoeRepository)
    }
}