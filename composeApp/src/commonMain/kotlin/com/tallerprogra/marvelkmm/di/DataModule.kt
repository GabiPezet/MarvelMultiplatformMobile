package com.tallerprogra.marvelkmm.di

import com.tallerprogra.marvelkmm.data.MarvelRepositoryImpl
import com.tallerprogra.marvelkmm.data.remote.ApiService
import com.tallerprogra.marvelkmm.domain.MarvelRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule =
    module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
                }
                install(DefaultRequest) {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "gateway.marvel.com"
                    }
                }
            }
        }
        factoryOf(::ApiService)
        factory<MarvelRepository> { MarvelRepositoryImpl(get()) }
    }
