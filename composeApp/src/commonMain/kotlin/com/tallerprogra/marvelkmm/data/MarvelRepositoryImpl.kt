package com.tallerprogra.marvelkmm.data

import com.tallerprogra.marvelkmm.data.remote.ApiService
import com.tallerprogra.marvelkmm.data.remote.response.CharactersResponse
import com.tallerprogra.marvelkmm.domain.MarvelRepository
import com.tallerprogra.marvelkmm.domain.model.CharacterModel


class MarvelRepositoryImpl(private val apiMarvel: ApiService): MarvelRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<CharacterModel> {
        return apiMarvel.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<CharacterModel>{
        return this.characters.list.map {
            CharacterModel(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnail = it.thumbnail.toUrl()
            )
        }
    }
}