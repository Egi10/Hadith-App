package id.buaja.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.repository.HadithRepositoryImpl
import id.buaja.data.source.local.HadithLocalDataSource
import id.buaja.data.source.remote.HadithRemoteDataSource
import id.buaja.domain.repository.HadithRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(
        remoteDataSource: HadithRemoteDataSource,
        localDataSource: HadithLocalDataSource
    ): HadithRepository {
        return HadithRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }
}