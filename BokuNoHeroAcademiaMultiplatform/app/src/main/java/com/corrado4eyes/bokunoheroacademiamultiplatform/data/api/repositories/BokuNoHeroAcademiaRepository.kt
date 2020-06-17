package com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse

interface BokuNoHeroAcademiaRepository {

    suspend fun getCharactersList(): List<BNHACharacterResponse>

}