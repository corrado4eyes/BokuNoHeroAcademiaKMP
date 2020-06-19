package com.corrado4eyes.bokunoheroacademiamultiplatform

import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.startKoin
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.context.stopKoin
import org.koin.dsl.module

fun setupKoin(dbHelper: DatabaseHelper, bnhaApi: BokuNoHeroAcademiaApi) {
    val testModule = module {
        single { dbHelper }
        single { bnhaApi }
    }

    startKoin { modules(testModule) }
}

fun tearDownKoin() {
    stopKoin()
}

expect fun getTestSqlDriver(): SqlDriver