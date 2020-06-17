package com.corrado4eyes.bokunoheroacademiamultiplatform.ktor

import co.touchlab.stately.ensureNeverFrozen
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.takeFrom
import io.ktor.util.KtorExperimentalAPI

@KtorExperimentalAPI
class BokuNoHeroAcademiaApiImpl : BokuNoHeroAcademiaApi {

    init {
        ensureNeverFrozen()
    }

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
            acceptContentTypes += ContentType("application","json+hal")
        }
    }

    override suspend fun getCharactersList(): List<BNHACharacterResponse> = network {
        return@network client.get<List<BNHACharacterResponse>> {
            characters("/list")
        }
    }

    private fun HttpRequestBuilder.characters(path: String) {
        url {
            takeFrom("http://192.168.1.78:8080")
            encodedPath = path
        }
    }
}

internal expect suspend fun <R> network(block: suspend () -> R): R
