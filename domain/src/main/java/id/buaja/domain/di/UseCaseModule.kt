package id.buaja.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.domain.repository.HadithRepository
import id.buaja.domain.usecase.HadithUseCase
import id.buaja.domain.usecase.HadithUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUseCase(
        repository: HadithRepository
    ): HadithUseCase {
        return HadithUseCaseImpl(repository)
    }
}