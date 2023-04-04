package com.k_salauyou.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.k_salauyou.vknewsclient.ui.ActivityResultTest
import com.k_salauyou.vknewsclient.ui.theme.MainScreen
import com.k_salauyou.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<NewsFeedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme{
                ActivityResultTest()
            }
        }
    }
}
