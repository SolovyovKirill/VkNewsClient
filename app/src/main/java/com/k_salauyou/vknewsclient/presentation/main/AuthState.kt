package com.k_salauyou.vknewsclient.presentation.main

sealed class AuthState {
    object Initial: AuthState()
    object Authorized : AuthState()
    object NoAuthorized : AuthState()
}
