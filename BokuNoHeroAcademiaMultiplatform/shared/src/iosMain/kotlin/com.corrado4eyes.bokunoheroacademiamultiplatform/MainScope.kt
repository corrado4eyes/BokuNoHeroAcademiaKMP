package com.corrado4eyes.bokunoheroacademiamultiplatform

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainScope(private val mainContext: CoroutineContext) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = mainContext + job + exceptionHandler

    internal val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        showError(throwable)
    }

    private fun showError(t: Throwable) {
        println("Error in MainScope" + t.message)
    }

    fun onDestroy(){
        job.cancel()
    }
}
