package com.hu.b1nd.local.mapper

import com.hu.b1nd.domain.model.ListHome
import com.hu.b1nd.local.entitiy.lost.LostEntity

internal fun List<LostEntity>.toModels() =
    this.map {
        it.toModel()
    }

internal fun LostEntity.toModel() =
    ListHome(
        thumbnail = this.thumbnail,
        title = this.title,
        content = this.content,
        author = this.author,
        date = this.date,
        id = this.idx,
    )
