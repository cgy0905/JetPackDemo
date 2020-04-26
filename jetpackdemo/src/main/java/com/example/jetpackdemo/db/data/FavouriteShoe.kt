package com.example.jetpackdemo.db.data

import androidx.room.*
import java.util.*

/**
 * @author: cgy
 * @date: 2020/4/24 16:44
 * @description:
 */
@Entity(
    tableName = "fav_shoe"
    ,
    foreignKeys = [ForeignKey(
        entity = Shoe::class,
        parentColumns = ["id"],
        childColumns = ["shoe_id"]
    )
        , ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])
    ],
    indices = [Index("shoe_id")]
)
data class FavouriteShoe(
    @ColumnInfo(name = "shoe_id")
    val shoeId: Long, // 外键 鞋子的id
    @ColumnInfo(name = "user_id")
    val userId: Long, // 外键 用户的id
    @ColumnInfo(name = "fav_date")
    val date: Calendar // 创建日期
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Long = 0
}