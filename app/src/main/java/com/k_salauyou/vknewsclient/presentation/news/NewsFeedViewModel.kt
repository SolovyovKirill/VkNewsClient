package com.k_salauyou.vknewsclient.presentation.news

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.k_salauyou.vknewsclient.data.repository.NewsFeedRepository
import com.k_salauyou.vknewsclient.domain.FeedPost
import com.k_salauyou.vknewsclient.extensions.mergeWith
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {
    
    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        Log.d("NewsFeedViewModel", "Exception caught by exception handler")
    }
    private val repository = NewsFeedRepository(application)
    private val recommendationFlow = repository.recommendations

    private val loadNextDataFlow = MutableSharedFlow<NewsFeedScreenState>()

    val screenState = recommendationFlow
        .filter { it.isNotEmpty() }
        .map { NewsFeedScreenState.Posts(posts = it) as NewsFeedScreenState }
        .onStart { emit(NewsFeedScreenState.Loading) }
        .mergeWith(loadNextDataFlow)

    fun loadNextRecommendations() {
        viewModelScope.launch {
            loadNextDataFlow.emit(
                NewsFeedScreenState.Posts(
                    posts = recommendationFlow.value,
                    nextDataIsLoading = true
                )
            )
            repository.loadNextData()
        }
    }

    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
            repository.changeLikeStatus(feedPost)
        }
    }

    fun remove(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
            repository.deletePost(feedPost)
        }
    }

}