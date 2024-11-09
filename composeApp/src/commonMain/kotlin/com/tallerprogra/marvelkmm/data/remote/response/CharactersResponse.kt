package com.tallerprogra.marvelkmm.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CharactersResponse (
    @SerialName("data") val characters: CharacterData
)

