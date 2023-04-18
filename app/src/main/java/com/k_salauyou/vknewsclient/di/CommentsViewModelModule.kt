package com.k_salauyou.vknewsclient.di

import androidx.lifecycle.ViewModel
import com.k_salauyou.vknewsclient.presentation.comments.CommentsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CommentsViewModelModule {

    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    @Binds
    fun bindCommentsViewModel(viewModel: CommentsViewModel) : ViewModel
}