package com.example.utils.usecases

import com.example.utils.core.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

abstract class FlowUseCase<in Params, Result>(private val coroutineDispatcher: CoroutineDispatcher) {
  @ExperimentalCoroutinesApi
  operator fun invoke(parameters: Params): Flow<DataState<Result>> =
    execute(parameters)
      .obtainOutcome()
      .flowOn(coroutineDispatcher)

  protected abstract fun execute(parameters: Params): Flow<Result>
}


fun <T> Flow<T>.obtainOutcome(): Flow<DataState<T>> =
  this.map { DataState.success(it) }
  .onStart { emit(DataState.Loading()) }
  .catch { e ->
    emit(DataState.Error(e.message))
  }
