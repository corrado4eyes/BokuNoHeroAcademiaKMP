package com.corrado4eyes.bokunoheroacademiamultiplatform.ktor

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse

interface BokuNoHeroAcademiaApi : CharactersApi

interface CharactersApi {

    suspend fun getCharactersList(): List<BNHACharacterResponse>

}