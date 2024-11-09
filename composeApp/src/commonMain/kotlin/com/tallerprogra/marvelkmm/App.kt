package com.tallerprogra.marvelkmm

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.tallerprogra.marvelkmm.ui.core.navigation.NavigationWrapped
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
            NavigationWrapped()
    }
}