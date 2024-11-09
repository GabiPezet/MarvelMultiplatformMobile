package com.tallerprogra.marvelkmm.data.database

import com.tallerprogra.marvelkmm.MarvelDatabase
import com.tallerprogra.marvelkmm.MarvelDatabaseQueries

class CacheRepositoryImpl(marvelDB: MarvelDatabase): CacheRepository {

    private val query: MarvelDatabaseQueries = marvelDB.marvelDatabaseQueries

    override suspend fun getCharactersFromCache(): List<CacheCharacter> {
        return query.getAllCharacters(::mapToCacheCharacter).executeAsList()
    }

    override suspend fun insertCharacterToCache(character: CacheCharacter) {
        val existingCharacter = query.getCharacter(character.id, ::mapToCacheCharacter).executeAsOneOrNull()
        if(existingCharacter == null){
            query.insertCharacter(character.id,character.name,character.description,character.thumbnail)
        }else{
            query.updateCharacter(character.name, character.description, character.thumbnail, character.id)
        }
    }

    override suspend fun deleteAllCharacters() {
        query.deleteAllCharacters()
    }

    override suspend fun deleteCharacter(id: Long) {
        query.deleteCharacter(id)
    }

    override suspend fun getById(id: Long): CacheCharacter {
        return query.getCharacter(id, ::mapToCacheCharacter).executeAsOne()
    }

    private fun mapToCacheCharacter(id: Long, name: String, description: String?, thumbnail: String?): CacheCharacter{
        return CacheCharacter(id, name, description, thumbnail)
    }

}