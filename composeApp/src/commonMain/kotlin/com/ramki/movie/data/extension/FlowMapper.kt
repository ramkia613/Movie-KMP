package com.ramki.movie.data.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

fun <T> flowTransform(block: suspend FlowCollector<T>.() -> T): Flow<T> {
    return flow {
        runCatching { block() }
            .onSuccess { result -> emit(result) }
            .onFailure { exception -> throw exception }
    }
}
