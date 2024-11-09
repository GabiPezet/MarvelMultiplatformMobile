package com.tallerprogra.marvelkmm.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tallerprogra.marvelkmm.ui.home.Routes
import com.tallerprogra.marvelkmm.ui.home.screens.cache.CacheScreen
import com.tallerprogra.marvelkmm.ui.home.screens.characters.CharactersScreen

@Composable
fun NavigationButtonWrapper(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Cache.route) {
        composable(route = Routes.Cache.route) { CacheScreen() }
        composable(route = Routes.Characters.route) { CharactersScreen() }
    }
}