package com.k_salauyou.vknewsclient

import android.app.Application
import com.k_salauyou.vknewsclient.di.ApplicationComponent
import com.k_salauyou.vknewsclient.di.DaggerApplicationComponent

class NewsFeedApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(
            this
        )
    }
}