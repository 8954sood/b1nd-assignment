package com.hu.b1nd.local.mapper

import com.hu.b1nd.domain.usecase.lost.CreateLostListUseCase
import com.hu.b1nd.local.entitiy.lost.LostEntity

internal fun List<CreateLostListUseCase.Param>.toModels(): List<LostEntity> =
    this.map {
        it.toModel()
    }

internal fun CreateLostListUseCase.Param.toModel(): LostEntity =
    LostEntity(
        thumbnail = thumbnail,
        title = title,
        content = content,
        author = author,
        date = date
    )