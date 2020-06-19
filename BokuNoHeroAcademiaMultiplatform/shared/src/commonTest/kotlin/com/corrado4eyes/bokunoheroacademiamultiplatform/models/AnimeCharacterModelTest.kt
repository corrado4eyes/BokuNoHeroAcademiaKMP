package com.corrado4eyes.bokunoheroacademiamultiplatform.models

import com.corrado4eyes.bokunoheroacademiamultiplatform.BaseTest
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse
import com.corrado4eyes.bokunoheroacademiamultiplatform.db.BNHACharacter
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.getTestSqlDriver
import com.corrado4eyes.bokunoheroacademiamultiplatform.mocks.BokuNoHeroAcademiaApiMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlin.test.*

class AnimeCharacterModelTest : BaseTest() {
    private lateinit var animeModel: AnimeCharacterModel
    private val bnhaApiMock = BokuNoHeroAcademiaApiMock()
    private var dbHelper = DatabaseHelper(getTestSqlDriver(), Dispatchers.Default)


    @BeforeTest
    fun setup() {
        animeModel = AnimeCharacterModel(bnhaApiMock, dbHelper)
    }

    @AfterTest
    fun cleanUp() {
        dbHelper.clearDb()
    }

    private fun checkCharacterEqualsProperties(result: BNHACharacter,
                                               expected: BNHACharacterResponse
    ) {
        assertEquals(result.id, expected.id)
        assertEquals(result.category, expected.category)
        assertEquals(result.characterClass, expected.characterClass)
        assertEquals(result.image, expected.image)
        assertEquals(result.name, expected.name)
        assertEquals(result.quirk, expected.quirk)
    }

    @Test
    fun `it successfully get a response and store it into the db`() = runTest {
        bnhaApiMock.mock.getCharactersList.returns(bnhaApiMock.success())
        assertNotNull(animeModel.syncDown())
        val result = dbHelper.getAll().first().first()
        checkCharacterEqualsProperties(result, BokuNoHeroAcademiaApiMock.dummyCharacter)
    }

    @Test
    fun `it insert a new character in the database`() = runTest {
        assertEquals(dbHelper.getAll().first(), emptyList())

        dbHelper.insertCharacter(listOf(BokuNoHeroAcademiaApiMock.dummyCharacter))

        checkCharacterEqualsProperties(dbHelper.getAll().first().first(),
            BokuNoHeroAcademiaApiMock.dummyCharacter
        )
    }
}