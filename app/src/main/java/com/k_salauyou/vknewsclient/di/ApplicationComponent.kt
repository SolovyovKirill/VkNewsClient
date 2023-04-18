package com.k_salauyou.vknewsclient.di

import android.content.Context
import com.k_salauyou.vknewsclient.domain.entity.FeedPost
import com.k_salauyou.vknewsclient.presentation.ViewModelFactory
import com.k_salauyou.vknewsclient.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    fun getCommentsScreenComponentFactory(): CommentsScreenComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): ApplicationComponent
    }
}