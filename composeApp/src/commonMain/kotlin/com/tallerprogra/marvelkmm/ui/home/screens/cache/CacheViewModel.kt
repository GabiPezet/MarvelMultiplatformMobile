package com.tallerprogra.marvelkmm.ui.home.screens.cache

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallerprogra.marvelkmm.domain.GetCharacterCacheUseCase
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CacheViewModel(private val getCharacterCacheUseCase: GetCharacterCacheUseCase) : ViewModel() {
    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                getCharacterCacheUseCase.getCharactersFromCache()
                _characters.value = getCharacterCacheUseCase.items.value
                _isLoading.value = false
                if (_characters.value.isEmpty()) {
                    val timestamp = getTimeMillis()
                    getCharacterCacheUseCase.getCharactersFromRemoteAndSaveToCache(timestamp)
                    _characters.value = getCharacterCacheUseCase.items.value
                    if (_characters.value.isNotEmpty()) {
                        _isLoading.value = false
                    }
                }
            } catch (e: Exception) {
                println("Data is is not being found, sorry.")
                return@launch
            }
        }
    }
}
