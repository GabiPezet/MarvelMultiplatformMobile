package com.tallerprogra.marvelkmm.di

import com.tallerprogra.marvelkmm.domain.usecases.GetCharacterCacheUseCase
import com.tallerprogra.marvelkmm.domain.usecases.GetCharactersApiUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        factoryOf(::GetCharactersApiUseCase)
        factoryOf(::GetCharacterCacheUseCase)
    }
