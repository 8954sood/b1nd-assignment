package com.hu.b1nd.domain.usecase.lost

import android.graphics.Bitmap
import com.hu.b1nd.domain.repository.LostRepository
import javax.inject.Inject

class CreateLostUseCase @Inject constructor(
    private val lostRepository: LostRepository
) {

    suspend operator fun invoke(param: Param) = kotlin.runCatching {
        lostRepository.create(
            thumbnail = param.thumbnail,
            title = param.title,
            content = param.content,
            author = param.author,
            date = param.date
        )
    }

    data class Param(
        val thumbnail: Bitmap,
        val title: String,
        val content: String,
        val author: String,
        val date: String
    )

}