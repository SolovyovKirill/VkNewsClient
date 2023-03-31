package com.k_salauyou.vknewsclient.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.k_salauyou.vknewsclient.MainViewModel
import com.k_salauyou.vknewsclient.ui.theme.NavigationItem.*

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val items =
                    listOf(
                        Home,
                        Favourite,
                        Profile
                    )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = selectedNavItem == item,
                        onClick = { viewModel.selectNavItem(item) },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        },
    ) { paddingValues ->
        when (selectedNavItem) {
            Home -> {
                HomeScreen(viewModel = viewModel, paddingValues = paddingValues)
            }
            Favourite -> TextCounter(name = "Favourite")
            Profile -> TextCounter(name = "Profile")
        }
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by remember {
        mutableStateOf(0)
    }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count",
        color = Color.Black
    )
}