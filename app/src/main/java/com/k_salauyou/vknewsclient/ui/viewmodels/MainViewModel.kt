package com.k_salauyou.vknewsclient.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.k_salauyou.vknewsclient.ui.states.AuthState
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult

class MainViewModel : ViewModel() {
    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        _authState.value = if (VK.isLoggedIn()) AuthState.Authorized else AuthState.NoAuthorized
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