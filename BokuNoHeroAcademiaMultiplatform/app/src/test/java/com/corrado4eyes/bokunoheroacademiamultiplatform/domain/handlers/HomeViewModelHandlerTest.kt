package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.handlers

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories.BokuNoHeroAcademiaRepository
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.handlers.HomeViewModelHandler
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.CoroutineTestRule
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.Dummies
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class HomeViewModelHandlerTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private lateinit var homeViewModelHandler: HomeViewModelHandler

    @ExperimentalCoroutinesApi
    @Test
    fun `it fetches a dummy character`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val bnhaRepo: BokuNoHeroAcademiaRepository = mock {
            onBlocking { getCharactersList() } doReturn listOf(Dummies.dummyCharacterResponse)
        }

        homeViewModelHandler = HomeViewModelHandlerImpl(bnhaRepo)

        Assert.assertEquals(Dummies.dummyCharacterResponse,
            homeViewModelHandler.getCharactersList().first()
        )
    }

}