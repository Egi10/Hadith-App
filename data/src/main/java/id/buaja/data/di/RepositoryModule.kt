package id.buaja.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.repository.HadithRepositoryImpl
import id.buaja.domain.repository.HadithRepository
import javax.inject.Singleton

/**
 * https://developer.android.com/training/dependency-injection/hilt-android#hilt-modules
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /**
    https://developer.android.com/training/dependency-injection/hilt-android#inject-interfaces
     */
    @Binds
    @Singleton
    abstract fun bindHadithRepository(
        hadithRepositoryImpl: HadithRepositoryImpl
    ): HadithRepository
}