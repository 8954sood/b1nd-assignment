package com.hu.b1nd.assignment.utiles

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.Toast
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getDate(): String {
    val pattern = "yyyy-MM-dd"

    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern(pattern)

    return currentDate.format(formatter)
}

internal fun Context.shortToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

internal fun Drawable.toBitmap(): Bitmap {
    val bitmapDrawable = this as BitmapDrawable
    return bitmapDrawable.bitmap
}