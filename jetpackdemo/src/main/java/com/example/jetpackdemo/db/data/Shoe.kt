package com.example.jetpackdemo.db.data

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: cgy
 * @date: 2020/4/24 16:13
 * @description:
 */
@Entity
data class Shoe(
    @ColumnInfo(name = "shoe_name")
    val name : String,
    @ColumnInfo(name = "shoe_description")
    val description : String,
    @ColumnInfo(name = "shoe_price")
    val price: Float,
    @ColumnInfo(name = "shoe_brand")
    val brand: String,
    @ColumnInfo(name = "shoe_imgUrl")
    val imageUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Long = 0

    fun getPriceStr() : String{
        return price.toString()
    }
}