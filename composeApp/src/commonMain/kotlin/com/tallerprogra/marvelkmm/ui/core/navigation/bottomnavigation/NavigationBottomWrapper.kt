package com.tallerprogra.marvelkmm.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tallerprogra.marvelkmm.ui.home.Routes
import com.tallerprogra.marvelkmm.ui.home.screens.characters.CharactersScreen
import com.tallerprogra.marvelkmm.ui.home.screens.comics.ComicsScreen

@Composable
fun NavigationButtonWrapper(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Comics.route) {
        composable(route = Routes.Comics.route) { ComicsScreen() }
        composable(route = Routes.Characters.route) { CharactersScreen() }
    }
}