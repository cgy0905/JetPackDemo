package com.example.jetpackdemo.db

import androidx.room.TypeConverter
import java.util.*

/**
 * @author: cgy
 * @date: 2020/4/24 16:58
 * @description: Type converters to allow Room to reference complex data types.
 */
class Converters {
    @TypeConverter fun calendarToDatestamp(calendar: Calendar) : Long = calendar.timeInMillis

    @TypeConverter fun datestampToCalendar(value : Long) : Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}