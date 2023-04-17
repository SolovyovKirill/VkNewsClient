package com.k_salauyou.vknewsclient.domain

sealed class AuthState {
    object Initial: AuthState()
    object Authorized : AuthState()
    object NoAuthorized : AuthState()
}
