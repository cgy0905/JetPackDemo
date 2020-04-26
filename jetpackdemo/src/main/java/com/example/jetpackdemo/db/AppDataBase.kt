package com.example.jetpackdemo.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jetpackdemo.db.dao.FavouriteShoeDao
import com.example.jetpackdemo.db.dao.ShoeDao
import com.example.jetpackdemo.db.dao.UserDao
import com.example.jetpackdemo.db.data.FavouriteShoe
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.db.data.User

/**
 * @author: cgy
 * @date: 2020/4/24 16:41
 * @description: 数据库文件
 */
@Database(entities = [User::class, Shoe::class, FavouriteShoe::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    //得到UserDao
    abstract fun userDao() : UserDao
    //得到ShoeDao
    abstract fun shoeDao() : ShoeDao
    //得到FavouriteShoeDao
    abstract fun favouriteShoeDao() : FavouriteShoeDao

    companion object {
        @Volatile
        private var instance : AppDataBase? = null

        fun getInstance(context : Context) : AppDataBase {
            return instance?: synchronized(this) {
                instance?: buildDataBase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDataBase(context: Context) : AppDataBase {
            return Room
                .databaseBuilder(context, AppDataBase::class.java, "jetPackDemo-database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .build()
        }
    }
}