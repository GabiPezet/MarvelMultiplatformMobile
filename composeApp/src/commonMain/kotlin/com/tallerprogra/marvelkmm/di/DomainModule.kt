package com.tallerprogra.marvelkmm.di

import com.tallerprogra.marvelkmm.domain.GetCharacterCacheUseCase
import com.tallerprogra.marvelkmm.domain.GetCharactersApiUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        factoryOf(::GetCharactersApiUseCase)
        factoryOf(::GetCharacterCacheUseCase)
    }
