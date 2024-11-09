package com.tallerprogra.marvelkmm.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CharacterData (
    @SerialName("results") val list: List<CharacterResult>
)