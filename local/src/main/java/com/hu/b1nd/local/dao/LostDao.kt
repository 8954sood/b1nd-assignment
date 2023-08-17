package com.hu.b1nd.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.hu.b1nd.local.base.BaseDao
import com.hu.b1nd.local.entitiy.lost.LostEntity


@Dao
interface LostDao: BaseDao<LostEntity> {
    @Query("SELECT * FROM lost_table")
    suspend fun getAllLost(): List<LostEntity>
}