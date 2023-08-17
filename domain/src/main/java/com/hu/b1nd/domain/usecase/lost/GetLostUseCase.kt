package com.hu.b1nd.domain.usecase.lost

import com.hu.b1nd.domain.repository.LostRepository
import javax.inject.Inject

class GetLostUseCase @Inject constructor(
    private val lostRepository: LostRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        lostRepository.get()
    }

}