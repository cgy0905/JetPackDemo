package com.example.jetpackdemo.common

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList


/**
 * @author: cgy
 * @date: 2020/4/24 17:28
 * @description:
 */
fun <T> DataSource.Factory<Int, T>.createPagerList(pageSize : Int, defaultSize : Int) : LiveData<PagedList<T>> {
    return LivePagedListBuilder<Int, T>(
        this, PagedList.Config.Builder()
            .setPageSize(2)
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(2)
            .build()
    ).build()
}