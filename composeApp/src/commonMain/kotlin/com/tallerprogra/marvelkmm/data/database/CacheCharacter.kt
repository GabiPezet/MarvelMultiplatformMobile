package com.tallerprogra.marvelkmm.data.database

import com.tallerprogra.marvelkmm.data.remote.response.ThumbnailResponse
import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CacheCharacter(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String?,
    @SerialName("thumbnail") val thumbnail: String?,
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            description = description.toString(),
            thumbnail = thumbnail.toString()
        )
    }
}