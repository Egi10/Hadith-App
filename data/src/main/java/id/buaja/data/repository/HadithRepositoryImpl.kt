package id.buaja.data.repository

import id.buaja.data.source.local.HadithLocalDataSource
import id.buaja.data.source.remote.HadithRemoteDataSource
import id.buaja.data.source.remote.network.ApiResult
import id.buaja.data.source.remote.response.HadithResponse
import id.buaja.data.utils.MappingData
import id.buaja.domain.ResultState
import id.buaja.domain.repository.HadithRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class HadithRepositoryImpl @Inject constructor(
    private val remoteDataSource: HadithRemoteDataSource,
    private val localDataSource: HadithLocalDataSource
) : HadithRepository {
    override suspend fun getHadith(): Flow<ResultState<Boolean>> {
        return flow {
            if (localDataSource.loadAllData().isNullOrEmpty()) {
                val listHadith: MutableList<HadithResponse> = mutableListOf()
                remoteDataSource.getHadith("abu-daud")
                    .map {
                        listHadith.addAll(addList(it))
                        return@map it
                    }
                    .zip(remoteDataSource.getHadith("ahmad")) { _, ahmad ->
                        listHadith.addAll(addList(ahmad))

                        return@zip ahmad
                    }
                    .zip(remoteDataSource.getHadith("bukhari")) { _, bukhari ->
                        listHadith.addAll(addList(bukhari))

                        return@zip bukhari
                    }
                    .zip(remoteDataSource.getHadith("darimi")) { _, darimi ->
                        listHadith.addAll(addList(darimi))

                        return@zip darimi
                    }
                    .zip(remoteDataSource.getHadith("ibnu-majah")) { _, ibnuMajah ->
                        listHadith.addAll(addList(ibnuMajah))

                        return@zip ibnuMajah
                    }
                    .zip(remoteDataSource.getHadith("nasai")) { _, nasai ->
                        listHadith.addAll(addList(nasai))

                        return@zip nasai
                    }
                    .zip(remoteDataSource.getHadith("malik")) { _, malik ->
                        listHadith.addAll(addList(malik))

                        return@zip malik
                    }
                    .zip(remoteDataSource.getHadith("muslim")) { _, muslim ->
                        listHadith.addAll(addList(muslim))

                        return@zip muslim
                    }
                    .collect {
                        when (it) {
                            is ApiResult.Success -> {
                                saveToLocal(data = listHadith)
                                emit(ResultState.Success(true))
                            }

                            is ApiResult.Error -> {
                                emit(ResultState.Error(it.throwable))
                            }
                        }
                    }
            } else {
                emit(ResultState.Success(true))
            }
        }
    }

    private suspend fun saveToLocal(data: List<HadithResponse>) {
        localDataSource.insertPost(MappingData.mapResponseToEntity(data))
    }

    private fun addList(data: ApiResult<List<HadithResponse>>): List<HadithResponse> {
        return when (data) {
            is ApiResult.Success -> {
                data.data
            }

            is ApiResult.Error -> {
                emptyList()
            }
        }
    }
}