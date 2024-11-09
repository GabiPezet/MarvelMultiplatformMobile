package com.tallerprogra.marvelkmm.data.database


interface CacheRepository {
    suspend fun getCharactersFromCache(): List<CacheCharacter>
    suspend fun insertCharacterToCache(character: CacheCharacter): Unit
    suspend fun deleteAllCharacters(): Unit
    suspend fun deleteCharacter(id: Long): Unit
    suspend fun getById(id: Long): CacheCharacter
}