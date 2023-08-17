package com.hu.b1nd.assignment.feature.info

import com.hu.b1nd.assignment.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(

): BaseViewModel() {

    fun onClickSubmit() {
        viewEvent(ON_CLICK_SUBMIT)
    }

    fun onClickBackIcon() {
        viewEvent(ON_CLICK_BACK_ICON)
    }
    companion object {
        const val ON_CLICK_SUBMIT = 0
        const val ON_CLICK_BACK_ICON = 1
    }
}