package id.buaja.domain.usecase

import id.buaja.domain.repository.HadithRepository
import javax.inject.Inject

class HadithUseCaseImpl @Inject constructor(private val repository: HadithRepository) :
    HadithUseCase {
    override suspend fun getHadith() = repository.getHadith()
}