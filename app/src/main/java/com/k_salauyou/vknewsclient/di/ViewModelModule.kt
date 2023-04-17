package com.k_salauyou.vknewsclient.di

import androidx.lifecycle.ViewModel
import com.k_salauyou.vknewsclient.presentation.comments.CommentsViewModel
import com.k_salauyou.vknewsclient.presentation.main.MainViewModel
import com.k_salauyou.vknewsclient.presentation.news.NewsFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    @Binds
    fun bindNewsFeedViewModel(viewModel: NewsFeedViewModel) : ViewModel

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(viewModel: MainViewModel) : ViewModel

    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    @Binds
    fun bindCommentsViewModel(viewModel: CommentsViewModel) : ViewModel
}