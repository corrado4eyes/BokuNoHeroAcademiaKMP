package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db

import com.corrado4eyes.bokunoheroacademiamultiplatform.db.BNHACharacter
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db.BokuNoHeroAcademiaMultiDb
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DatabaseHelper(private val sqlDriver: SqlDriver,
                     private val backgroundDispatcher: CoroutineDispatcher
) {
    private var dbRef: BokuNoHeroAcademiaMultiDb = BokuNoHeroAcademiaMultiDb(sqlDriver)

    fun clearDb() {
        sqlDriver.close()
    }

    fun getAll(): Flow<List<BNHACharacter>> =
        dbRef.tableQueries
            .getAll()
            .asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

    suspend fun insertCharacter(bnhaCharacter: List<BNHACharacterResponse>) {
        dbRef.transactionWithContext(backgroundDispatcher) {
            bnhaCharacter.forEach { character ->
                dbRef.tableQueries.insertCharacter(
                    character.id,
                    character.name,
                    character.image,
                    character.category,
                    character.characterClass,
                    character.quirk
                )
            }
        }
    }
}