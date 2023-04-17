package com.k_salauyou.vknewsclient.domain.usecases

import com.k_salauyou.vknewsclient.domain.repository.NewsFeedRepository

class CheckAuthStateUseCase(
    private val repository: NewsFeedRepository
) {
    suspend operator fun invoke() {
        repository.checkAuthState()
    }
}