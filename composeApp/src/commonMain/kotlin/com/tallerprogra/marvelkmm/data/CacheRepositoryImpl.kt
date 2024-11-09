package com.tallerprogra.marvelkmm.data

import com.tallerprogra.marvelkmm.DatabaseDriverFactory
import com.tallerprogra.marvelkmm.MarvelDatabase
import com.tallerprogra.marvelkmm.MarvelDatabaseQueries
import com.tallerprogra.marvelkmm.domain.CacheRepository
import com.tallerprogra.marvelkmm.domain.model.CharacterModel

class CacheRepositoryImpl(driverFactory: DatabaseDriverFactory): CacheRepository {
    private val marvelDB = MarvelDatabase(driverFactory.createDriver())
    private val query: MarvelDatabaseQueries = marvelDB.marvelDatabaseQueries

    override suspend fun getCharactersFromCache(): List<CharacterModel> {
        query
        TODO("Not yet implemented")
    }


}