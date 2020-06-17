package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di

import com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db.BokuNoHeroAcademiaMultiDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> { NativeSqliteDriver(BokuNoHeroAcademiaMultiDb.Schema, "bnhamulti_db") }
}

object KoiniOS {
    val koin = startKoin { }

    fun get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
        val kClazz = getOriginalKotlinClass(objCClass)!!
        return koin.koin.get(kClazz, qualifier) { parametersOf(parameter) }
    }

    fun get(objCClass: ObjCClass, parameter: Any): Any {
        val kClazz = getOriginalKotlinClass(objCClass)!!
        return koin.koin.get(kClazz, null) { parametersOf(parameter) }
    }

    fun get(objCClass: ObjCClass, qualifier: Qualifier?): Any {
        val kClazz = getOriginalKotlinClass(objCClass)!!
        return koin.koin.get(kClazz, qualifier, null)
    }
}