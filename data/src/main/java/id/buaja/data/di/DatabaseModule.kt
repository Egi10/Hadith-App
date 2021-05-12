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
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HadithDatabase = Room.databaseBuilder(
        context,
        HadithDatabase::class.java, "hadith.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: HadithDatabase): HadithDao = database.postDao()
}