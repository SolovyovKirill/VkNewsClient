package com.k_salauyou.vknewsclient.domain.usecases

import com.k_salauyou.vknewsclient.domain.entity.FeedPost
import com.k_salauyou.vknewsclient.domain.repository.NewsFeedRepository

class DeletePostUseCase(
    private val repository: NewsFeedRepository
) {
    suspend operator fun invoke(feedPost: FeedPost) {
        repository.deletePost(feedPost)
    }
}