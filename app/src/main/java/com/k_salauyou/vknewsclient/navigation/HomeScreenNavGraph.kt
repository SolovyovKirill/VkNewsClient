package com.k_salauyou.vknewsclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.k_salauyou.vknewsclient.domain.entity.FeedPost
import com.k_salauyou.vknewsclient.navigation.Screen.Companion.KEY_FEED_POST

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(KEY_FEED_POST) {
                    type = FeedPost.NavigationType
                },
            )
        ) {
//            val feedPostJson = it.arguments?.getString(KEY_FEED_POST) ?: ""
//            val feedPost = Gson().fromJson(feedPostJson, FeedPost::class.java)
            val feedPost = it.arguments?.getParcelable<FeedPost>(KEY_FEED_POST)
                ?: throw RuntimeException("Args is null")
            commentsScreenContent(feedPost)
        }
    }
}