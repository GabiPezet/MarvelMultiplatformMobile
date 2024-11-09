package com.tallerprogra.marvelkmm

import androidx.compose.ui.window.ComposeUIViewController
import com.tallerprogra.marvelkmm.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }
