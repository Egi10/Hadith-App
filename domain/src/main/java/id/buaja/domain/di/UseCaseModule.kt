package id.buaja.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.domain.usecase.HadithUseCase
import id.buaja.domain.usecase.HadithUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsUseCase(hadithUseCaseImpl: HadithUseCaseImpl): HadithUseCase
}