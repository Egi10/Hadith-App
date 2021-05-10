package id.buaja.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.buaja.data.source.local.entity.HadithEntity

@Dao
interface HadithDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHadith(post: List<HadithEntity>)

    @Query("SELECT * FROM hadith LIMIT 10")
    fun loadAllHadith(): List<HadithEntity>
}