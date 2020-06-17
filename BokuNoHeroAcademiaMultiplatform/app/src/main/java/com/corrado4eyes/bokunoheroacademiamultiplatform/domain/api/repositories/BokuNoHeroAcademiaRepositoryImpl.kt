package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.api.repositories

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories.BokuNoHeroAcademiaRepository
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import org.koin.core.KoinComponent

class BokuMyHeroAcademiaRepositoryImpl(private val bokuNoHeroAcademiaApi: BokuNoHeroAcademiaApi) :
    BokuNoHeroAcademiaRepository, KoinComponent {

    override suspend fun getCharactersList(): List<BNHACharacterResponse> =
        bokuNoHeroAcademiaApi.getCharactersList()

}