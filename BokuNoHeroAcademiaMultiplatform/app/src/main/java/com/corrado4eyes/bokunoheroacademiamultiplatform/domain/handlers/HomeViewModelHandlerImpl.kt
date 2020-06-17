package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.handlers

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories.BokuNoHeroAcademiaRepository
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.handlers.HomeViewModelHandler

class HomeViewModelHandlerImpl(
    private val bokuNoHeroAcademiaRepository: BokuNoHeroAcademiaRepository
) : HomeViewModelHandler {


    override suspend fun getCharactersList(): List<BNHACharacterResponse> =
        bokuNoHeroAcademiaRepository.getCharactersList()
}