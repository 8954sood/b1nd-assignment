package com.hu.b1nd.assignment.feature.create

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.hu.b1nd.assignment.base.BaseViewModel
import com.hu.b1nd.assignment.utiles.getDate
import com.hu.b1nd.domain.usecase.lost.CreateLostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateViewModel @Inject constructor(
    private val createLostUseCase: CreateLostUseCase
): BaseViewModel() {

    fun createLost(
        thumbnail: Bitmap,
        title: String,
        content: String,
        author: String
    ) {
        viewModelScope.launch {
            createLostUseCase(
                CreateLostUseCase.Param(
                    thumbnail = thumbnail,
                        title = title,
                    content = content,
                    author = author,
                    date = getDate()
                )
            ).onSuccess {
                viewEvent(EVENT_CREATE_SUCCESS)
            }.onFailure {
                viewEvent(EVENT_CREATE_FAILED)
            }
        }

    }

    fun onClickImage() {
        viewEvent(ON_CLICK_IMAGE)
    }

    fun onClickSubmit() {
        viewEvent(ON_CLICK_SUBMIT)
    }

    companion object {
        const val ON_CLICK_IMAGE = 0
        const val ON_CLICK_SUBMIT = 1
        const val EVENT_CREATE_SUCCESS = 2
        const val EVENT_CREATE_FAILED = 3
    }

}