package id.buaja.domain.usecase

import id.buaja.domain.ResultState
import id.buaja.domain.repository.HadithRepository
import kotlinx.coroutines.flow.Flow

class HadithUseCaseImpl(private val repository: HadithRepository) : HadithUseCase {
    override suspend fun getHadith() = repository.getHadith()
}