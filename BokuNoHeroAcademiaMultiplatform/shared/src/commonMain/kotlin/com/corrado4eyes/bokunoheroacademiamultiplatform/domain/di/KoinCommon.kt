package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di

import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db.DatabaseHelper
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApiImpl
import com.corrado4eyes.bokunoheroacademiamultiplatform.models.AnimeCharacterModel
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun startKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule)
}

private val commonModule = module {
        single { AnimeCharacterModel(get(), get()) }
        single<BokuNoHeroAcademiaApi> { BokuNoHeroAcademiaApiImpl() }
        single { DatabaseHelper(get(), Dispatchers.Default) }
}
expect val platformModule: Module