package com.corrado4eyes.bokunoheroacademiamultiplatform

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db.BokuNoHeroAcademiaMultiDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun getTestSqlDriver(): SqlDriver {
    val app = ApplicationProvider.getApplicationContext<Application>()
    return AndroidSqliteDriver(BokuNoHeroAcademiaMultiDb.Schema, app, "bnha_test_db")
}