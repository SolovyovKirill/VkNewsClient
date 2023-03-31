package com.k_salauyou.vknewsclient.ui.theme

import com.k_salauyou.vknewsclient.domain.FeedPost
import com.k_salauyou.vknewsclient.domain.PostComment

sealed class HomeScreenState {

    object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>): HomeScreenState()

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): HomeScreenState()

}
