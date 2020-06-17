package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules

import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApi
import com.corrado4eyes.bokunoheroacademiamultiplatform.ktor.BokuNoHeroAcademiaApiImpl
import com.corrado4eyes.bokunoheroacademiamultiplatform.utils.CoroutineUtil
import com.corrado4eyes.bokunoheroacademiamultiplatform.utils.DefaultDispatcherProvider
import com.corrado4eyes.bokunoheroacademiamultiplatform.utils.DispatcherProvider
import org.koin.dsl.module

class CoroutinesModule {

    companion object {
        val coroutinesModule = module {

            single<DispatcherProvider> {
                DefaultDispatcherProvider()
            }
            single {
                CoroutineUtil(get())
            }
        }
    }

}