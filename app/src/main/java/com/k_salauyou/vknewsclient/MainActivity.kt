package com.k_salauyou.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.k_salauyou.vknewsclient.ui.screens.LoginScreen
import com.k_salauyou.vknewsclient.ui.states.AuthState
import com.k_salauyou.vknewsclient.ui.theme.MainScreen
import com.k_salauyou.vknewsclient.ui.theme.VkNewsClientTheme
import com.k_salauyou.vknewsclient.ui.viewmodels.MainViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.authState.observeAsState(AuthState.Initial)
                val launcher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                ) {
                    viewModel.performAuthResult(it)
                }

                when (authState.value) {
                    is AuthState.Authorized -> {
                        MainScreen()
                    }
                    is AuthState.NoAuthorized -> {
                        LoginScreen {
                            launcher.launch(listOf(VKScope.WALL))
                        }
                    }
                    else -> {

                    }
                }
            }
        }
    }
}
