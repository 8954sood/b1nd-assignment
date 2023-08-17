package com.hu.b1nd.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.hu.b1nd.local.dao.LostDao
import com.hu.b1nd.local.entitiy.lost.LostEntity
import com.hu.b1nd.local.util.RoomTypeConverter

@TypeConverters(RoomTypeConverter::class)
@Database(
    entities = [
        LostEntity::class
    ],
    version = 1
)
abstract class B1ndAssignmentDataBase: RoomDatabase() {
    abstract fun lostDao(): LostDao

}