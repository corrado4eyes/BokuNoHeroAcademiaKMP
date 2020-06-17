package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.api.repositories.BokuNoHeroAcademiaRepository
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.api.repositories.BokuMyHeroAcademiaRepositoryImpl
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApiImpl
import org.koin.dsl.module

class NetworkModule {

    companion object {
        val networkModule = module {
            single<BokuNoHeroAcademiaRepository> {
                BokuMyHeroAcademiaRepositoryImpl(get())
            }
        }
    }

}