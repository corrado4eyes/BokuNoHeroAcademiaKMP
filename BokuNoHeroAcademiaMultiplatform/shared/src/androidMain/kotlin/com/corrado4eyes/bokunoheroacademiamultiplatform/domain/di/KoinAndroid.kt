package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di

import com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db.BokuNoHeroAcademiaMultiDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.module.Module
import org.koin.dsl.module


actual val platformModule: Module = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            BokuNoHeroAcademiaMultiDb.Schema,
            get(),
            "KampStarterDb"
        )
    }
}