package com.corrado4eyes.bokunoheroacademiamultiplatform

import com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db.BokuNoHeroAcademiaMultiDb
import co.touchlab.sqliter.DatabaseConfiguration
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.squareup.sqldelight.drivers.native.wrapConnection

actual fun getTestSqlDriver(): SqlDriver {
    val schema = BokuNoHeroAcademiaMultiDb.Schema
    return NativeSqliteDriver(
        DatabaseConfiguration(
            name = "bnha_test_db",
            version = schema.version,
            create = { connection ->
                wrapConnection(connection) { schema.create(it) }
            },
            upgrade = { connection, oldVersion, newVersion ->
                wrapConnection(connection) { schema.migrate(it, oldVersion, newVersion) }
            },
            inMemory = true
        )
    )
}