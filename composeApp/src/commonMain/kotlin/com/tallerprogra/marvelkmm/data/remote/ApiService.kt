package com.tallerprogra.marvelkmm.data.remote

import com.tallerprogra.marvelkmm.data.remote.response.CharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val clientMarvel: HttpClient) {

    suspend fun getAllCharacters(timestamp: Long, md5: String): CharactersResponse {
        return clientMarvel.get("v1/public/characters"){
            parameter("ts", timestamp)
            parameter("hash", md5)
            parameter("apikey", PUBLIC_KEY)
        }.body()
    }
}