package com.tallerprogra.marvelkmm.di


import com.tallerprogra.marvelkmm.DatabaseDriverFactory
import com.tallerprogra.marvelkmm.createDatabase
import com.tallerprogra.marvelkmm.data.database.CacheRepositoryImpl
import com.tallerprogra.marvelkmm.data.database.CacheRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val cacheModule =
    module {
        single <CacheRepository>{ CacheRepositoryImpl(createDatabase(DatabaseDriverFactory())) }
    }