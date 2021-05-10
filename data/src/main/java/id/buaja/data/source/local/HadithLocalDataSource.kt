package id.buaja.data.source.local

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.di.IoDispatcher
import id.buaja.data.source.local.entity.HadithEntity
import id.buaja.data.source.local.room.HadithDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class HadithLocalDataSource @Inject constructor(
    private val hadithDao: HadithDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun insertPost(listHadith: List<HadithEntity>) = withContext(dispatcher) {
        hadithDao.insertHadith(listHadith)
    }

    suspend fun loadAllData() = withContext(dispatcher) {
        hadithDao.loadAllHadith()
    }
}