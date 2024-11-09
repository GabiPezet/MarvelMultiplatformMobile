package com.tallerprogra.marvelkmm.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tallerprogra.marvelkmm.ui.home.screens.HomeScreen
import com.tallerprogra.marvelkmm.ui.home.Routes


@Composable
fun NavigationWrapped() {
    val mainNavController = rememberNavController()
    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }
    }
}