package com.k_salauyou.vknewsclient

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.k_salauyou.vknewsclient.di.ApplicationComponent
import com.k_salauyou.vknewsclient.di.DaggerApplicationComponent

class NewsFeedApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(
            this
        )
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    Log.d("RECOMPOSITION_TAG", "getApplicationComponent")
    return (LocalContext.current.applicationContext as NewsFeedApplication).component
}