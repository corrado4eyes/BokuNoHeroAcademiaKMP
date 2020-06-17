package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.di.modules

import com.corrado4eyes.bokunoheroacademiamultiplatform.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelsModule {
    companion object {
        val module = module {
            viewModel { HomeViewModel(get(), get()) }
        }
    }
}