package com.k_salauyou.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.k_salauyou.vknewsclient.data.repository.NewsFeedRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsFeedRepository(application)

    val authState = repository.authStateFlow

    fun performAuthResult() {
        viewModelScope.launch {
            repository.checkAuthState()
        }
    }
}