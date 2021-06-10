package id.buaja.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.source.remote.network.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * https://developer.android.com/training/dependency-injection/hilt-android#hilt-modules
 */

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    /**
    https://developer.android.com/training/dependency-injection/hilt-android#inject-provides
     */
    @Provides
    @Singleton
    fun provideService(): ApiService {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://islamic-api-indonesia.herokuapp.com/api/data/json/hadith/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}