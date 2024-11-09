package com.tallerprogra.marvelkmm.ui.home

sealed class Routes(val route: String) {

    data object Home : Routes("home")
    data object Comics : Routes("comics")
    data object Characters : Routes("characters")
}