package com.example.jetpackdemo.db.repository

import androidx.lifecycle.LiveData
import com.example.jetpackdemo.db.dao.FavouriteShoeDao
import com.example.jetpackdemo.db.data.FavouriteShoe
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.util.*

/**
 * @author: cgy
 * @date: 2020/4/24 17:10
 * @description:
 */
class FavouriteShoeRepository private constructor(private val favouriteShoeDao: FavouriteShoeDao){

    /**
     * 查看某个用户是否有喜欢的记录
     */
    fun findFavouriteShoe(userId : Long, shoeId : Long) : LiveData<FavouriteShoe?>
        = favouriteShoeDao.findFavouriteShoeByUserIdAndShoeId(userId, shoeId)

    /**
     * 收藏一双鞋子
     */
    suspend fun createFavouriteShoe(userId: Long, shoeId: Long) {
        withContext(IO) {
            favouriteShoeDao.insertFavouriteShoe(FavouriteShoe(shoeId, userId, Calendar.getInstance()))
        }
    }

    companion object {
        @Volatile
        private var instance : FavouriteShoeRepository? = null

        fun getInstance(favouriteShoeDao: FavouriteShoeDao) : FavouriteShoeRepository =
            instance ?: synchronized(this) {
                instance ?: FavouriteShoeRepository(favouriteShoeDao).also {
                    instance = it
                }
            }
    }
}