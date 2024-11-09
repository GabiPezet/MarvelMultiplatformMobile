package com.tallerprogra.marvelkmm.di

import com.tallerprogra.marvelkmm.ui.home.screens.cache.CacheViewModel
import com.tallerprogra.marvelkmm.ui.home.screens.characters.CharactersViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule =
    module {
        viewModelOf(::CharactersViewModel)
        viewModelOf(::CacheViewModel)
    }
