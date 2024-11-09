package com.tallerprogra.marvelkmm.ui.home.screens.characters

import com.tallerprogra.marvelkmm.domain.model.CharacterModel

data class CharacterState(
    val characters: List<CharacterModel> = emptyList()
)