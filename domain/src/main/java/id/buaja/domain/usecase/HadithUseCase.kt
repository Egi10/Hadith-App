package id.buaja.domain.usecase

import id.buaja.domain.ResultState
import kotlinx.coroutines.flow.Flow

interface HadithUseCase {
    suspend fun getHadith(): Flow<ResultState<Boolean>>
}