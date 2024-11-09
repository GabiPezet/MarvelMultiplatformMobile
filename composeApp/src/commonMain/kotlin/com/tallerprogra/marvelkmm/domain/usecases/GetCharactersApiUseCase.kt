package com.tallerprogra.marvelkmm.domain.usecases

import com.soywiz.krypto.MD5
import com.tallerprogra.marvelkmm.data.remote.PRIVATE_KEY
import com.tallerprogra.marvelkmm.data.remote.PUBLIC_KEY
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import com.tallerprogra.marvelkmm.domain.repo.MarvelRepository
import io.ktor.util.date.getTimeMillis
import io.ktor.utils.io.core.toByteArray

class GetCharactersApiUseCase(private val repository: MarvelRepository) {

    suspend operator fun invoke(): List<CharacterModel> {
        val timestamp = getTimeMillis()
        val md5 = hashWithMD5(timestamp.toString() + PRIVATE_KEY + PUBLIC_KEY)
        val characters = repository.getCharacters(timestamp, md5)
        return sort(characters)
    }

    private fun hashWithMD5(string: String): String {
        val messageDigest = MD5.digest(string.toByteArray())
        return messageDigest.hex
    }

    private fun sort(characters: List<CharacterModel>): List<CharacterModel> {
        return characters.sortedWith(CharacterComparator())
    }

    private class CharacterComparator : Comparator<CharacterModel> {
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