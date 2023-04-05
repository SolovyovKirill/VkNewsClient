package com.k_salauyou.vknewsclient.ui.states

sealed class AuthState {
    object Initial: AuthState()
    object Authorized : AuthState()
    object NoAuthorized : AuthState()
}
