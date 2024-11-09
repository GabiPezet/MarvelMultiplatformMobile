package com.tallerprogra.marvelkmm.ui.home.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallerprogra.marvelkmm.domain.usecases.GetCharactersApiUseCase
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(val getCharacterApiUseCase: GetCharactersApiUseCase) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                delay(1000)
                val fetchedCharacters = getCharacterApiUseCase()
                delay(1000)
                _characters.value = fetchedCharacters
            } catch (e: Exception) {
                _error.value = "This Device has no internet connection"
            } finally {
                _isLoading.value = false
            }
        }
    }
}