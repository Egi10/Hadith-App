package id.buaja.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.buaja.data.source.local.entity.HadithEntity

@Database(entities = [HadithEntity::class], version = 1, exportSchema = false)
abstract class HadithDatabase : RoomDatabase() {
    abstract fun postDao(): HadithDao
}