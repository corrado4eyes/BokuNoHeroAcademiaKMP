package com.corrado4eyes.bokunoheroacademiamultiplatform.models

import co.touchlab.stately.ensureNeverFrozen
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import kotlinx.coroutines.flow.collect
import org.koin.core.KoinComponent
import co.touchlab.stately.ensureNeverFrozen

class AnimeCharacterModel(
    private val kTorApi: BokuNoHeroAcademiaApi,
    private val dbHelper: DatabaseHelper
) : KoinComponent {

    init {
        ensureNeverFrozen()
    }

    private suspend fun storeNewCharactersInLocalDb(characterResponses: List<BNHACharacterResponse>) {
        dbHelper.insertBreeds(characterResponses)
    }

    private suspend fun fetchCharacters(): List<BNHACharacterResponse> {
        return kTorApi.getCharactersList()
    }

    fun getAll() = dbHelper.selectAllItems()

    suspend fun syncDown() = storeNewCharactersInLocalDb(fetchCharacters())
}