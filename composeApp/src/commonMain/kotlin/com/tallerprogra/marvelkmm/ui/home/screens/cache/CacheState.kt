package com.tallerprogra.marvelkmm.ui.home.screens.cache

import com.tallerprogra.marvelkmm.domain.model.CharacterModel

data class CacheState (
    val characters: List<CharacterModel> = emptyList()
)