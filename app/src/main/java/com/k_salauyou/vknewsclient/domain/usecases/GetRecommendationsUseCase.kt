package com.k_salauyou.vknewsclient.domain.usecases

import com.k_salauyou.vknewsclient.domain.entity.FeedPost
import com.k_salauyou.vknewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetRecommendationsUseCase(
    private val repository: NewsFeedRepository
) {
    operator fun invoke(): StateFlow<List<FeedPost>> {
        return repository.getRecommendations()
    }
}