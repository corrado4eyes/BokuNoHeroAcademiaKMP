package com.corrado4eyes.bokunoheroacademiamultiplatform.domain.db

import co.touchlab.stately.freeze
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Turns this [Query] into a [Flow] which emits whenever the underlying result set changes.
 *
 * Note: We copied this from the sqldelight repo because we're using the new native coroutines draft version.
 * When that is live, we'll be using the official sqldelight version.
 */
@JvmName("toFlow")
internal fun <T : Any> Query<T>.asFlow(): Flow<Query<T>> = flow {
    emit(this@asFlow)
    val channel = Channel<Unit>(CONFLATED).freeze()

    val listener = object : Query.Listener {
        override fun queryResultsChanged() {
            channel.offer(Unit)
        }
    }

    addListener(listener)
    try {
        for (item in channel) {
            emit(this@asFlow)
        }
    } catch (e: Error) {
        println("****** Error ******")
        println("Error is: " + e.message)
    } finally {
        println("****** Closing Flow in removeListener ******")
        removeListener(listener)
    }
}

@JvmOverloads
internal fun <T : Any> Flow<Query<T>>.mapToOne(
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = map {
    withContext(context) {
        it.executeAsOne()
    }
}

@JvmOverloads
internal fun <T : Any> Flow<Query<T>>.mapToOneOrDefault(
    defaultValue: T,
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = map {
    withContext(context) {
        it.executeAsOneOrNull() ?: defaultValue
    }
}

@JvmOverloads
internal fun <T : Any> Flow<Query<T>>.mapToOneOrNull(
    context: CoroutineContext = Dispatchers.Default
): Flow<T?> = map {
    withContext(context) {
        it.executeAsOneOrNull()
    }
}

@JvmOverloads
internal fun <T : Any> Flow<Query<T>>.mapToOneNotNull(
    context: CoroutineContext = Dispatchers.Default
): Flow<T> = mapNotNull {
    withContext(context) {
        it.executeAsOneOrNull()
    }
}

@JvmOverloads
internal fun <T : Any> Flow<Query<T>>.mapToList(
    context: CoroutineContext = Dispatchers.Default
): Flow<List<T>> = map {
    withContext(context) {
        it.executeAsList()
    }
}

suspend fun Transacter.transactionWithContext(
    coroutineContext: CoroutineContext,
    noEnclosing: Boolean = false,
    body: Transacter.Transaction.() -> Unit
) {
    withContext(coroutineContext) {
        this@transactionWithContext.transaction(noEnclosing) { body() }
    }
}
