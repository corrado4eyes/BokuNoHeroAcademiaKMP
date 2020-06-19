package com.corrado4eyes.bokunoheroacademiamultiplatform.models

import co.touchlab.stately.ensureNeverFrozen
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.db.BNHACharacter
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import kotlinx.coroutines.flow.Flow
import org.koin.core.KoinComponent

open class AnimeCharacterModel(
    private val kTorApi: BokuNoHeroAcademiaApi,
    private val dbHelper: DatabaseHelper
) : KoinComponent {

    init {
        ensureNeverFrozen()
    }

    private suspend fun storeNewCharactersInLocalDb(characterResponses: List<BNHACharacterResponse>) {
        dbHelper.insertCharacter(characterResponses)
    }

    private suspend fun fetchCharacters(): List<BNHACharacterResponse> {
        return kTorApi.getCharactersList()
    }

    fun getAll(): Flow<List<BNHACharacter>> = dbHelper.getAll()

    suspend fun syncDown() = storeNewCharactersInLocalDb(fetchCharacters())
}