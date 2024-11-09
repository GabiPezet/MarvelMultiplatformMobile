package com.tallerprogra.marvelkmm.ui.core.navigation.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.tallerprogra.marvelkmm.ui.home.Routes

sealed class BottomBarItem {
    abstract val route: String
    abstract val title: String
    abstract val icon: @Composable () -> Unit


    data class Comics(
        override val route: String = Routes.Cache.route,
        override val title: String = "Cache",
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Star, "")
        }
    ) : BottomBarItem()

    data class Characters(
        override val route: String = Routes.Characters.route,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Person, "")
        }
    ) : BottomBarItem()
}