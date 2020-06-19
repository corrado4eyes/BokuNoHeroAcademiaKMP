package com.corrado4eyes.bokunoheroacademiamultiplatform.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.corrado4eyes.bokunoheroacademiamultiplatform.db.BNHACharacter
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.models.AnimeCharacterModel
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.CoroutineTestRule
import com.corrado4eyes.bokunoheroacademiamultiplatform.testUtils.Dummies
import com.corrado4eyes.bokunoheroacademiamultiplatform.utils.CoroutineUtil
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var viewModel: HomeViewModel
    private lateinit var model: AnimeCharacterModel
    private val sqlDriver = mock<SqlDriver>()
    private val dbHelper = DatabaseHelper(sqlDriver, Dispatchers.Default)


    @ExperimentalCoroutinesApi
    private val coroutineUtil = CoroutineUtil(coroutineTestRule.testDispatcherProvider)

    @ExperimentalCoroutinesApi
    @Test
    fun `it fetches a character`() = runBlocking {
        model = mock {
            on { getAll() } doReturn flowOf(listOf(Dummies.dummyCharacterResponse as BNHACharacter))
        }

        viewModel = HomeViewModel(coroutineUtil, model)

        Assert.assertEquals(viewModel.charactersList.value?.size, 0)

        viewModel.syncDown()
        viewModel.getCharactersList()

        Assert.assertNotEquals(viewModel.charactersList.value?.size, 0)

    }
}