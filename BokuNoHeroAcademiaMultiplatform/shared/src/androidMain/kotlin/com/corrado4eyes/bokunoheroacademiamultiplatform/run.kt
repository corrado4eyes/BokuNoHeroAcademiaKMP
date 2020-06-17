package com.corrado4eyes.bokunoheroacademiamultiplatform

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

actual fun <T> runBlocking(context: CoroutineContext, block: suspend CoroutineScope.() -> T): T
        = runBlocking(context) { block() }

//actual fun runOnMain(block: () -> Unit) {
//    CoroutineScope(Dispatchers.Main).launch {
//        block()
//    }
//}