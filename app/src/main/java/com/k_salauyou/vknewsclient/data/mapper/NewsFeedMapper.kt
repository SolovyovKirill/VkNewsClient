package com.k_salauyou.vknewsclient.data.mapper

import com.k_salauyou.vknewsclient.data.model.NewsFeedResponseDto
import com.k_salauyou.vknewsclient.domain.FeedPost
import com.k_salauyou.vknewsclient.domain.StatisticItem
import com.k_salauyou.vknewsclient.domain.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
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
                publicationDate = mapTimestamp(post.date * 1000),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, post.likes.count),
                    StatisticItem(type = StatisticType.COMMENTS, post.comments.count),
                    StatisticItem(type = StatisticType.SHARES, post.reposts.count),
                    StatisticItem(type = StatisticType.VIEWS, post.views.count),
                ),
                isFavourite = post.isFavourite
            )
            result.add(feedPost)
        }
        return result
    }

    private fun mapTimestamp(timestamp: Long): String {
        val date = Date(timestamp)
        return SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }
}