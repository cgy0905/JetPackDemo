package com.example.jetpackdemo.db.repository

import com.example.jetpackdemo.db.dao.ShoeDao
import com.example.jetpackdemo.db.data.Shoe

/**
 * @author: cgy
 * @date: 2020/4/24 16:33
 * @description:
 */
class ShoeRepository private constructor(private val shoeDao: ShoeDao) {
    /**
     * 通过id的范围寻找鞋子
     */
    fun getPageShoes(startIndex : Long, endIndex : Long) : List<Shoe> = shoeDao.findShoesByIndexRange(startIndex, endIndex)
    fun getAllShoes() = shoeDao.getAllShoesLD()

    /**
     * 通过品牌查询鞋子
     */
    fun getShoesByBrand(brand : Array<String>) = shoeDao.findShoesByBrandLD(brand)

    /**
     * 通过id查询一双鞋
     */
    fun getShoeById(id : Long) = shoeDao.findShoeByIdLD(id)

    /**
     * 查询用户收藏的鞋
     */
    fun getShoesByUserId(userId : Long) = shoeDao.findShoesByUserId(userId)

    /**
     * 插入鞋子的集合
     */
    fun insertShoes(shoes : List<Shoe>) = shoeDao.insertShoes(shoes)

    companion object {
        @Volatile
        private var instance : ShoeRepository? = null

        fun getInstance(shoeDao: ShoeDao) : ShoeRepository =
            instance ?: synchronized(this) {
                instance ?: ShoeRepository(shoeDao).also {
                    instance = it
                }
            }
    }


}