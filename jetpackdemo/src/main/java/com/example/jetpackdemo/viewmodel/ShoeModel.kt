package com.example.jetpackdemo.viewmodel

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.jetpackdemo.common.createPagerList
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.db.datasource.CustomPageDataSourceFactory
import com.example.jetpackdemo.db.repository.ShoeRepository

/**
 * @author: cgy
 * @date: 2020/5/11 10:40
 * @description:
 */
class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {

    //品牌的观察对象,默认观察所有的品牌
    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    val shoes: LiveData<PagedList<Shoe>> = brand.switchMap {
        //Room数据库查询,只要知道返回的是LiveData<List<Shoe>>即可
        if (it == ALL) {
            LivePagedListBuilder<Int, Shoe>(
                CustomPageDataSourceFactory(shoeRepository),
                PagedList.Config.Builder()
                    .setPageSize(10) //分页加载的数量
                    .setEnablePlaceholders(false) //预加载的数量
                    .setInitialLoadSizeHint(10) //预加载的数量
                    .build()
            ).build()
        } else {
            val array: Array<String> =
                when (it) {
                    NIKE -> arrayOf("Nike", "Air Jordan")
                    ADIDAS -> arrayOf("Adidas")
                    else -> arrayOf("Converse", "UA", "ANTA")
                }
            shoeRepository.getShoesByBrand(array)
                .createPagerList(6, 6)
        }
    }

    fun setBrand(brand : String) {
        this.brand.value = brand

        this.brand.map {

        }
    }

    fun clearBrand() {
        this.brand.value = ALL
    }

    companion object {
        public const val ALL = "所有"

        public const val NIKE = "Nike"
        public const val ADIDAS = "Adidas"
        public const val OTHER = "other"
    }



}