package com.hu.b1nd.assignment.feature.home

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.hu.b1nd.assignment.base.BaseViewModel
import com.hu.b1nd.assignment.utiles.getDate
import com.hu.b1nd.domain.usecase.lost.CreateLostListUseCase
import com.hu.b1nd.domain.usecase.lost.GetLostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLostUseCase: GetLostUseCase,
    private val createLostListUseCase: CreateLostListUseCase
): BaseViewModel() {

    private val _getAllHomeState = MutableSharedFlow<HomeState>()

    val getAllHomeState: SharedFlow<HomeState> = _getAllHomeState.asSharedFlow()
    fun getLostList(
        thumbnail : Bitmap
    ) {
        viewModelScope.launch {
            getLostUseCase(

            ).onSuccess { result ->

                if (result.isEmpty()) {
                    val data = mutableListOf<CreateLostListUseCase.Param>()
                    val date = getDate()
                    for (i in 1..100) {
                        data.add(
                            CreateLostListUseCase.Param(
                                thumbnail = thumbnail,
                                title = "과제를 찾습니다 $i",
                                content = "제 과제가 사라졌어요",
                                author = "박병준 $i",
                                date = date
                            )
                        )
                    }
                    createLostListUseCase(data)
                    getLostUseCase().onSuccess {
                        _getAllHomeState.emit(HomeState(list =it))
                        return@launch
                    }
                }
                _getAllHomeState.emit(HomeState(list =result))
                return@launch
                }
            }
        }

    fun onClickAdd() {
        viewEvent(ON_CLICK_ADD)
    }

    companion object {
        const val ON_CLICK_ADD = 0
    }
}