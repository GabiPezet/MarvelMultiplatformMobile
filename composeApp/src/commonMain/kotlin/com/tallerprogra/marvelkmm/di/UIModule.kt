package com.tallerprogra.marvelkmm.di

import com.tallerprogra.marvelkmm.ui.home.screens.characters.CharactersViewModel
import com.tallerprogra.marvelkmm.ui.home.screens.comics.ComicsViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule =
    module {
        viewModelOf(::ComicsViewModel)
        viewModelOf(::CharactersViewModel)
    }
