package com.corrado4eyes.bokunoheroacademiamultiplatform.ktor

actual suspend fun <R> network(block: suspend () -> R): R = block()
