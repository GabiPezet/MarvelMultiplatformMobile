package com.tallerprogra.marvelkmm.domain.usecases


import androidx.compose.runtime.mutableStateOf
import com.soywiz.krypto.MD5
import com.tallerprogra.marvelkmm.data.database.CacheCharacter
import com.tallerprogra.marvelkmm.data.database.CacheRepository
import com.tallerprogra.marvelkmm.data.remote.PRIVATE_KEY
import com.tallerprogra.marvelkmm.data.remote.PUBLIC_KEY
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import com.tallerprogra.marvelkmm.domain.repo.MarvelRepository
import io.ktor.utils.io.core.toByteArray

class GetCharacterCacheUseCase(
    private val cacheRepo: CacheRepository,
    private val marvelRepo: MarvelRepository,
    getCharactersApiUseCase: GetCharactersApiUseCase
) {

    val items = mutableStateOf(listOf<CharacterModel>())

    suspend fun getCharactersFromCache() {
        val cacheCharacters: List<CacheCharacter> = cacheRepo.getCharactersFromCache()
        val characterList = cacheCharacters.map {
            it.toDomain()
        }
        items.value = sortCharactersCache(characterList).toList()
    }

    suspend fun getCharactersFromRemoteAndSaveToCache(timestamp: Long){
        val characterList = marvelRepo.getCharacters(timestamp, hashWithMD5(timestamp.toString() + PRIVATE_KEY + PUBLIC_KEY))
        items.value = sortCharactersCache(characterList).toList()
        saveCacheCharacters(characterList)
    }

    private suspend fun saveCacheCharacters(characters: List<CharacterModel>){
        cacheRepo.deleteAllCharacters()
        characters.forEach {
            val cacheCharacter = CacheCharacter(
                it.id,
                it.name,
                it.description,
                it.thumbnail
            )
            cacheRepo.insertCharacterToCache(cacheCharacter)
        }
    }

    private fun hashWithMD5(string: String): String {
        val messageDigest = MD5.digest(string.toByteArray())
        return messageDigest.hex
    }

    private fun sortCharactersCache(characters: List<CharacterModel>): List<CharacterModel> {
        return characters.sortedWith(CharacterCacheComparator())
    }

    private class CharacterCacheComparator : Comparator<CharacterModel> {
        override fun compare(c1: CharacterModel, c2: CharacterModel): Int {
            if (c1.description.isEmpty() && c2.description.isEmpty()) {
                return c2.id.compareTo(c1.id)
            }
            if (c1.description.isNotEmpty() && c2.description.isNotEmpty()) {
                return c1.id.compareTo(c2.id)
            }
            if (c1.description.isNotEmpty() && c2.description.isEmpty()) {
                return -1
            }
            return 1
        }
    }
}