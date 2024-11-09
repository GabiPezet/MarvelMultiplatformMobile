package com.tallerprogra.marvelkmm.di


import com.tallerprogra.marvelkmm.data.CacheRepositoryImpl
import com.tallerprogra.marvelkmm.domain.CacheRepository
import org.koin.dsl.module

val cacheModule =
    module {
        factory <CacheRepository>{ CacheRepositoryImpl(get())}
    }