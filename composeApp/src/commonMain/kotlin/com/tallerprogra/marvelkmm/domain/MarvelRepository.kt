package com.tallerprogra.marvelkmm.domain

import com.tallerprogra.marvelkmm.domain.model.CharacterModel


interface MarvelRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<CharacterModel>
}