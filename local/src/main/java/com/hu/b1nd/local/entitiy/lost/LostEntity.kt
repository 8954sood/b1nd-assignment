package com.hu.b1nd.local.entitiy.lost

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hu.b1nd.local.table.B1ndAssignment


@Entity(
    tableName = B1ndAssignment.LOST
)
data class LostEntity(
    @PrimaryKey(autoGenerate = true) val idx: Int,
    val thumbnail: Bitmap,
    val title: String,
    val content: String,
    val author: String,
    val date: String
) {
    constructor(thumbnail: Bitmap, title: String, content: String, author: String, date: String): this(0, thumbnail, title, content, author, date)
}