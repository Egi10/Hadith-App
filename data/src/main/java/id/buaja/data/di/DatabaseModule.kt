package id.buaja.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.buaja.data.source.local.room.HadithDao
import id.buaja.data.source.local.room.HadithDatabase
import javax.inject.Singleton

/**
 * https://developer.android.com/training/dependency-injection/hilt-android#hilt-modules
 */

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HadithDatabase = Room.databaseBuilder(
        context,
        HadithDatabase::class.java, "hadith.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideTourismDao(database: HadithDatabase): HadithDao = database.postDao()
}