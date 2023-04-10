package com.k_salauyou.vknewsclient.data.model.comments

import com.google.gson.annotations.SerializedName

data class CommentsContentDro(
    @SerializedName("items") val comments: List<CommentDto>,
    @SerializedName("profiles") val profiles: List<ProfileDto>,

)
