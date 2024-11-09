package com.tallerprogra.marvelkmm.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThumbnailResponse(
    @SerialName("path") val path: String,
    @SerialName("extension") val extension: String
){
    fun toUrl() : String {
        return "$path.$extension"
    }
}
