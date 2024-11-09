package com.tallerprogra.marvelkmm.domain

import com.tallerprogra.marvelkmm.domain.model.CharacterModel

interface CacheRepository {
    suspend fun getCharactersFromCache(): List<CharacterModel>
}