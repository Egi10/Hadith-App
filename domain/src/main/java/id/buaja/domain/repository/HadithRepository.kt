package id.buaja.domain.repository

import id.buaja.domain.ResultState
import id.buaja.domain.model.Hadith
import kotlinx.coroutines.flow.Flow

interface HadithRepository {
    suspend fun getHadith(): Flow<ResultState<Boolean>>
}