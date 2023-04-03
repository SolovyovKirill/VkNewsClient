package com.k_salauyou.vknewsclient.ui.theme

import com.k_salauyou.vknewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()
}