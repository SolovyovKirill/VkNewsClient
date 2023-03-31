package com.k_salauyou.vknewsclient.domain

import com.k_salauyou.vknewsclient.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.post_comunity_thumbnail,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)