package com.corrado4eyes.bokunoheroacademiamultiplatform.mocks

import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import co.touchlab.karmok.MockManager
import com.corrado4eyes.bokunoheroacademiamultiplatform.data.characters.BNHACharacterResponse

class BokuNoHeroAcademiaApiMock : BokuNoHeroAcademiaApi {
    internal val mock = InnerMock()

    companion object {

        val dummyCharacter = BNHACharacterResponse("first_id",
            "crazy_image",
            "Tester",
            "JetBrains",
            "Testerino",
            "Mock"
        )

    }

    override suspend fun getCharactersList(): List<BNHACharacterResponse> {
        return mock.getCharactersList.invokeSuspend({ getCharactersList() }, listOf())
    }

    class InnerMock(delegate: Any? = null) : MockManager(delegate) {
        internal val getCharactersList =
            MockFunctionRecorder<BokuNoHeroAcademiaApiMock, List<BNHACharacterResponse>>()
    }

    fun success(): List<BNHACharacterResponse> {
        return listOf(dummyCharacter)
    }
}