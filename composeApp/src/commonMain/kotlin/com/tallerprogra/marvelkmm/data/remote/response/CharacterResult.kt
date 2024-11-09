package com.tallerprogra.marvelkmm.data.remote.response

import com.tallerprogra.marvelkmm.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CharacterResult(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("thumbnail") val thumbnail: ThumbnailResponse,
) {
//    fun toDomain(): CharacterModel {
//        return CharacterModel(
//            id = id,
//            name = name,
//            description = description,
//            thumbnail = thumbnail.toUrl()
//        )
//    }
}