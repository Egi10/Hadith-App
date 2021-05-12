package id.buaja.data.source.remote

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.di.IoDispatcher
import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.source.remote.network.ApiService
import id.buaja.data.source.remote.response.HadithResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@Singleton
class HadithRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getHadith(name: String): Flow<ApiResult<List<HadithResponse>>> {
        return flow {
            try {
                emit(ApiResult.Success(getAndAddNameToResponse(name)))
            } catch (t: Throwable) {
                emit(ApiResult.Error(t))
            }
        }.flowOn(ioDispatcher)
    }

    private suspend fun getAndAddNameToResponse(name: String): MutableList<HadithResponse> {
        val list: MutableList<HadithResponse> = mutableListOf()
        val response = apiService.getHadith(name)
        response.map {
            list.add(
                HadithResponse(
                    number = it.number,
                    id = it.id,
                    arab = it.arab,
                    name = name
                )
            )
        }
        return list
    }
}