package com.k_salauyou.vknewsclient.data.mapper

import com.k_salauyou.vknewsclient.data.model.NewsFeedResponseDto
import com.k_salauyou.vknewsclient.domain.FeedPost
import com.k_salauyou.vknewsclient.domain.StatisticItem
import com.k_salauyou.vknewsclient.domain.StatisticType
import kotlin.math.absoluteValue

class NewsFeedMapper {
    fun mapResponseToPosts(responseDto: NewsFeedResponseDto): List<FeedPost> {
        val result = mutableListOf<FeedPost>()

        val posts = responseDto.newsFeedContent.posts
        val groups = responseDto.newsFeedContent.groups

        for (post in posts) {
            val group = groups.find { it.id == post.communityId.absoluteValue } ?: break
            val feedPost = FeedPost(
                id = post.id,
                communityName = group.name,
                publicationDate = post.date.toString(),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, post.likes.count),
                    StatisticItem(type = StatisticType.COMMENTS, post.comments.count),
                    StatisticItem(type = StatisticType.SHARES, post.reposts.count),
                    StatisticItem(type = StatisticType.VIEWS, post.views.count),
                )
            )
            result.add(feedPost)
        }


        return result
    }
}