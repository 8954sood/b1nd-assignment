package com.hu.b1nd.data.repository

import android.graphics.Bitmap
import android.util.Log
import com.hu.b1nd.data.BaseRepository
import com.hu.b1nd.data.datasource.lost.LostCacheDataSource
import com.hu.b1nd.domain.model.ListHome
import com.hu.b1nd.domain.repository.LostRepository
import com.hu.b1nd.domain.usecase.lost.CreateLostListUseCase
import javax.inject.Inject

class LostRepositoryImpl @Inject constructor(
    override val cache: LostCacheDataSource
): BaseRepository<LostCacheDataSource>, LostRepository {
    override suspend fun get(): List<ListHome> =
        cache.get()

    override suspend fun create(thumbnail: Bitmap, title: String, content: String, author: String, date: String) =
        cache.create(thumbnail, title, content, author ,date)

    override suspend fun createList(lostList: List<CreateLostListUseCase.Param>) {
        cache.createList(lostList)
    }

}