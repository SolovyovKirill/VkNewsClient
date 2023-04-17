package com.k_salauyou.vknewsclient.presentation.news

import com.k_salauyou.vknewsclient.domain.entity.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    object Loading: NewsFeedScreenState()

    data class Posts(
        val posts: List<FeedPost>,
        val nextDataIsLoading: Boolean = false
    ) : NewsFeedScreenState()
}
