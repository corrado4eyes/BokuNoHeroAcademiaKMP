package com.corrado4eyes.bokunoheroacademiamultiplatform

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

actual fun <T> runBlocking(context: CoroutineContext, block: suspend CoroutineScope.() -> T): T
        = kotlinx.coroutines.runBlocking(context, block)

//actual fun runOnMain(block: () -> Unit) {
//    dispatch_async(dispatch_get_main_queue(), block)
//}