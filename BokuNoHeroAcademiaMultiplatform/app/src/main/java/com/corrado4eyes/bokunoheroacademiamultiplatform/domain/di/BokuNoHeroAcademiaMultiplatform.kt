package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di

import android.app.Application
import android.content.Context
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules.CoroutinesModule
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules.HandlersModule
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules.NetworkModule
import com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules.ViewModelsModule
import org.koin.dsl.module

class BokuNoHeroAcademiaMultiplatform: Application() {

    override fun onCreate() {
        super.onCreate()

        val appContextModule = module {
            single<Context> { this@BokuNoHeroAcademiaMultiplatform }
        }

        startKoin {

            modules(NetworkModule.networkModule,
                CoroutinesModule.coroutinesModule,
                HandlersModule.handlersModule,
                ViewModelsModule.module,
                appContextModule
            )
        }

    }
}