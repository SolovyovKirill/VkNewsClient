package com.k_salauyou.vknewsclient

import android.app.Application
import com.k_salauyou.vknewsclient.di.ApplicationComponent
import com.k_salauyou.vknewsclient.di.DaggerApplicationComponent
import com.k_salauyou.vknewsclient.domain.entity.FeedPost

class NewsFeedApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(
            this,
            FeedPost(0, 0, "", "", "", "", "", listOf(), false)
        )
    }
}