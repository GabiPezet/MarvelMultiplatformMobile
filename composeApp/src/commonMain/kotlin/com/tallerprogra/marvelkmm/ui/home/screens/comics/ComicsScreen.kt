package com.tallerprogra.marvelkmm.ui.home.screens.comics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.tallerprogra.marvelkmm.apptheme.AppColors.IndigoDye
import com.tallerprogra.marvelkmm.apptheme.AppColors.VioletSky
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ComicsScreen(){
    val comicsViewModel = koinViewModel<ComicsViewModel>()
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(
                brush =
                Brush.verticalGradient(
                    listOf(VioletSky, IndigoDye),
                    startY = 0f,
                    endY = 1200f,
                ),
            ),
        contentAlignment = Alignment.Center,
    ){

    }
}