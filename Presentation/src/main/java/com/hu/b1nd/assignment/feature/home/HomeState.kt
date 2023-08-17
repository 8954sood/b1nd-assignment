package com.hu.b1nd.assignment.feature.home

import android.text.BoringLayout
import com.hu.b1nd.domain.model.ListHome

data class HomeState(
    val list: List<ListHome> = listOf(),
)
