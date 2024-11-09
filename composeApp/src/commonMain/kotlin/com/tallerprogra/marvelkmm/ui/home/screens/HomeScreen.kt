package com.tallerprogra.marvelkmm.ui.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tallerprogra.marvelkmm.apptheme.AppColors.IndigoDye
import com.tallerprogra.marvelkmm.apptheme.AppColors.SilverB
import com.tallerprogra.marvelkmm.apptheme.AppColors.VioletSky
import com.tallerprogra.marvelkmm.ui.core.navigation.bottomnavigation.BottomBarItem
import com.tallerprogra.marvelkmm.ui.core.navigation.bottomnavigation.NavigationButtonWrapper

@Composable
fun HomeScreen() {
    val items = listOf(BottomBarItem.Comics(), BottomBarItem.Characters())
    val navControllerHome = rememberNavController()

    Scaffold(bottomBar = { BottomNavigation(items, navControllerHome) }) {
        Box(
            modifier =
            Modifier
                .fillMaxSize()
                .background(
                    brush =
                    Brush.verticalGradient(
                        listOf(IndigoDye, VioletSky),
                        startY = 0f,
                        endY = 1100f,
                    ),
                ),
            contentAlignment = Alignment.Center,
        ){
            NavigationButtonWrapper(navControllerHome)
        }
    }
}

@Composable
fun BottomNavigation(items: List<BottomBarItem>, navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                alwaysShowLabel = false,
                label = { Text(item.title) },
                onClick = {
                    navController.navigate(route = item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            )
        }
    }
}
