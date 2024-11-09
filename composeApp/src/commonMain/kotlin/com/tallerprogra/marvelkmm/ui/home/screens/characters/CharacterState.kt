package com.tallerprogra.marvelkmm.ui.home.screens.characters

import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharacterState(
    val characters: List<CharacterModel> = emptyList()
)