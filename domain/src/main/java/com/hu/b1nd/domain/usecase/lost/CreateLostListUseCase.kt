package com.hu.b1nd.domain.usecase.lost

import android.graphics.Bitmap
import com.hu.b1nd.domain.repository.LostRepository
import javax.inject.Inject

class CreateLostListUseCase @Inject constructor(
    private val lostRepository: LostRepository
) {


    suspend operator fun invoke(param: List<Param>) = kotlin.runCatching {
        lostRepository.createList(param)
    }

    data class Param(
        val thumbnail: Bitmap,
        val title: String,
        val content: String,
        val author: String,
        val date: String
    )

}