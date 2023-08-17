package com.hu.b1nd.data.datasource.lost

import android.graphics.Bitmap
import com.hu.b1nd.domain.model.ListHome
import com.hu.b1nd.domain.usecase.lost.CreateLostListUseCase

interface LostCacheDataSource {

    suspend fun get(): List<ListHome>

    suspend fun create(
        thumbnail: Bitmap,
        title: String,
        content: String,
        author: String,
        date: String,
    )

    suspend fun createList(
        lostList: List<CreateLostListUseCase.Param>
    )
}