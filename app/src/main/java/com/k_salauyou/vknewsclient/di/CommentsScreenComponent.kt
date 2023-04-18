package com.k_salauyou.vknewsclient.di

import com.k_salauyou.vknewsclient.domain.entity.FeedPost
import com.k_salauyou.vknewsclient.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        CommentsViewModelModule::class
    ]
)
interface CommentsScreenComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance feedPost: FeedPost
        ): CommentsScreenComponent
    }
}