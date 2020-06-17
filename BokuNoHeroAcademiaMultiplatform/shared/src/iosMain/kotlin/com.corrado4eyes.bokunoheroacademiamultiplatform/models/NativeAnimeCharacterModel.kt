package com.corrado4eyes.bokunoheroacademiamultiplatform.models

import com.corrado4eyes.bokunoheroacademiamultiplatform.MainScope
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.db.BNHACharacter
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.koin.core.parameter.parametersOf
import org.koin.core.inject
import co.touchlab.stately.ensureNeverFrozen
import com.corrado4eyes.bokunoheroacademiamultiplatform.runBlocking


class NativeAnimeCharacterModel(
    private val viewUpdate: (List<BNHACharacterResponse>) -> Unit,
    private val errorUpdate: (String) -> Unit
): KoinComponent {

    private val ktorApi: BokuNoHeroAcademiaApi by inject()
    private val dbHelper: DatabaseHelper by inject()
//    private val scope = MainScope(Dispatchers.Main)

    private val animeCharacterModel: AnimeCharacterModel = AnimeCharacterModel(ktorApi, dbHelper)

    init {
        ensureNeverFrozen()
    }

    fun getCharactersList() = runBlocking {
        animeCharacterModel.getAll().collect { it ->
            val charactersList = it.map { el: BNHACharacter ->
                BNHACharacterResponse(el.id,
                    el.image,
                    el.category,
                    el.characterClass,
                    el.name,
                    el.quirk
                )
            }
            viewUpdate(charactersList)
        }
    }

    fun syncDown() = runBlocking {
        animeCharacterModel.syncDown()
    }
}
