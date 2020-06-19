package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.api.repositories

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories.BokuNoHeroAcademiaRepository
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.CoroutineTestRule
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.Dummies
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class BokuNoHeroAcademiaRepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private lateinit var bnhaRepository: BokuNoHeroAcademiaRepository

    @ExperimentalCoroutinesApi
    @Test
    fun `it fetches a dummy character`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val bnhaApi: BokuNoHeroAcademiaApi = mock {
            onBlocking { getCharactersList() } doReturn listOf(Dummies.dummyCharacterResponse)
        }
        bnhaRepository = BokuMyHeroAcademiaRepositoryImpl(bnhaApi)

        Assert.assertEquals(Dummies.dummyCharacterResponse, bnhaRepository.getCharactersList().first())
    }

}