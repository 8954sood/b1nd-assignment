package com.hu.b1nd.domain.model

import android.graphics.Bitmap

data class ListHome(
    var thumbnail: Bitmap?,
    var title: String?,
    var content: String?,
    var date: String?,
    var author: String?,
    var id: Int?
)
