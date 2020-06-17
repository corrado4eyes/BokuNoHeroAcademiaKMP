package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules

import com.corrado4eyes.bokunoheroacademiamultiplatform.data.handlers.HomeViewModelHandler
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.handlers.HomeViewModelHandlerImpl
import org.koin.dsl.module

class HandlersModule {

    companion object {
        val handlersModule = module {
            single<HomeViewModelHandler> {
                HomeViewModelHandlerImpl(get())
            }
        }
    }

}