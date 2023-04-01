package com.k_salauyou.vknewsclient.ui.theme

import com.k_salauyou.vknewsclient.domain.FeedPost
import com.k_salauyou.vknewsclient.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}