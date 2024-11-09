package com.tallerprogra.marvelkmm.ui.home.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallerprogra.marvelkmm.domain.GetCharactersApiUseCase
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(val getCharacterApiUseCase: GetCharactersApiUseCase): ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters

    init {
            fetchCharacters()
    }

    private fun fetchCharacters(){
        viewModelScope.launch {
            delay(1000)
            val fetchedCharacters = getCharacterApiUseCase()
            delay(1000)
            _characters.value = fetchedCharacters
        }
    }
}