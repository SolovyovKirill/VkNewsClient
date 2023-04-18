package com.k_salauyou.vknewsclient.di

import android.content.Context
import com.k_salauyou.vknewsclient.data.network.ApiFactory
import com.k_salauyou.vknewsclient.data.network.ApiService
import com.k_salauyou.vknewsclient.data.repository.NewsFeedRepositoryImpl
import com.k_salauyou.vknewsclient.domain.repository.NewsFeedRepository
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(implementation: NewsFeedRepositoryImpl): NewsFeedRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideVkStorage(
            context: Context
        ): VKPreferencesKeyValueStorage {
            return VKPreferencesKeyValueStorage(context)
        }
    }

}