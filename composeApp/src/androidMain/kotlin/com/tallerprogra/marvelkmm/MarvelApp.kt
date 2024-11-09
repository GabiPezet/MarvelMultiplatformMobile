package com.tallerprogra.marvelkmm

import android.app.Application
import com.tallerprogra.marvelkmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MarvelApp)
        }
    }
}
