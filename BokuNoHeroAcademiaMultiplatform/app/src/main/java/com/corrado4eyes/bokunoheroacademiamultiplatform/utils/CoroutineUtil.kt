package com.corrado4eyes.bokunoheroacademiamultiplatform.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

class CoroutineUtil(private val dispatcher: DispatcherProvider) {


    suspend fun <T> doInBackground(block: suspend CoroutineScope.() -> T): T =
        withContext(dispatcher.default()) {
            return@withContext block()
        }
}

