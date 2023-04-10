package com.k_salauyou.vknewsclient.data.model.comments

import com.google.gson.annotations.SerializedName

data class CommentsResponseDto(
    @SerializedName("response") val content: CommentsContentDro
)
