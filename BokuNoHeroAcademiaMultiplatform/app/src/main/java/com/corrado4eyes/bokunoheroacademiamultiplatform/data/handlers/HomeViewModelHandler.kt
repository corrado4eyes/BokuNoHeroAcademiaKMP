package com.corrado4eyes.bokunoheroacademiamultiplatform.data.handlers

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse

interface HomeViewModelHandler {

    suspend fun getCharactersList(): List<BNHACharacterResponse>

}