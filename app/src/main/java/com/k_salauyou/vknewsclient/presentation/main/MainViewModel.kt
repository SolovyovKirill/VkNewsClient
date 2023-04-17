package com.k_salauyou.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.k_salauyou.vknewsclient.data.repository.NewsFeedRepositoryImpl
import com.k_salauyou.vknewsclient.domain.usecases.CheckAuthStateUseCase
import com.k_salauyou.vknewsclient.domain.usecases.GetAuthStateFlowUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsFeedRepositoryImpl(application)

    private val getAuthStateFlowUseCase = GetAuthStateFlowUseCase(repository)
    private val checkAuthStateUseCase = CheckAuthStateUseCase(repository)


    val authState = getAuthStateFlowUseCase()

    fun performAuthResult() {
        viewModelScope.launch {
            checkAuthStateUseCase()
        }
    }
}