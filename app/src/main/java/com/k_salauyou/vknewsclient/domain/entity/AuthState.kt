package com.k_salauyou.vknewsclient.domain.entity

sealed class AuthState {
    object Initial: AuthState()
    object Authorized : AuthState()
    object NoAuthorized : AuthState()
}
