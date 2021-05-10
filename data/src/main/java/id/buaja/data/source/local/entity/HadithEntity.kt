package id.buaja.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hadith")
data class HadithEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_hadith")
    val idHadith: Int = 0,

    @ColumnInfo(name = "no")
    val no: Int,

    @ColumnInfo(name = "arab")
    val arab: String,

    @ColumnInfo(name = "translator")
    val translator: String,

    @ColumnInfo(name = "name")
    val name: String
)
