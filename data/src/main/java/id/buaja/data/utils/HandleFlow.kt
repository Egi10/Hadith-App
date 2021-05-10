package id.buaja.data.utils

import id.buaja.data.source.remote.network.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T : Any> fetchData(call: suspend () -> T): Flow<ApiResult<T>> = flow {
    try {
        emit(ApiResult.Success(data = call.invoke()))
    } catch (e: Throwable) {
        emit(ApiResult.Error(throwable = e))
    }
}