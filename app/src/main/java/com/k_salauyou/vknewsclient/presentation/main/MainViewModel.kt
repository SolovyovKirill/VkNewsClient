package com.k_salauyou.vknewsclient.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage)
        val loggedIn = token != null && token.isValid
        Log.d("MainViewModelTag", "Token: ${token?.accessToken}")
        _authState.value = if (loggedIn) AuthState.Authorized else AuthState.NoAuthorized
    }

    fun performAuthResult(result: VKAuthenticationResult) {
        if (result is VKAuthenticationResult.Success) {
            _authState.value = AuthState.Authorized
        } else {
            (result as VKAuthenticationResult.Failed)
            Log.d("MainViewModelTag", result.exception.authError.toString())
            _authState.value = AuthState.NoAuthorized
        }
    }
}