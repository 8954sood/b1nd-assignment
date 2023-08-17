package com.hu.b1nd.local.datasource

import android.graphics.Bitmap
import android.util.Log
import com.hu.b1nd.data.datasource.lost.LostCacheDataSource
import com.hu.b1nd.domain.model.ListHome
import com.hu.b1nd.domain.usecase.lost.CreateLostListUseCase
import com.hu.b1nd.local.dao.LostDao
import com.hu.b1nd.local.entitiy.lost.LostEntity
import com.hu.b1nd.local.mapper.toModels
import javax.inject.Inject

class LostCacheDataSourceImpl @Inject constructor(
    private val lostDao: LostDao
): LostCacheDataSource {
    override suspend fun get(): List<ListHome> =
        lostDao.getAllLost().toModels()

    override suspend fun create(
        thumbnail: Bitmap,
        title: String,
        content: String,
        author: String,
        date: String,
    ) {
        lostDao.insert(
            LostEntity(
                thumbnail, title, content, author, date
            )
        )
    }

    override suspend fun createList(lostList: List<CreateLostListUseCase.Param>) {
        lostDao.insert(lostList.toModels())
    }

}