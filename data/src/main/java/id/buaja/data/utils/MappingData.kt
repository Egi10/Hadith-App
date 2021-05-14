package id.buaja.data.utils

import id.buaja.data.source.local.entity.HadithEntity
import id.buaja.data.source.remote.response.HadithResponse

object MappingData {
    fun mapResponseToEntity(list: List<HadithResponse>): List<HadithEntity> {
        val listHadith: MutableList<HadithEntity> = mutableListOf()

        list.map {
            listHadith.add(
                HadithEntity(
                    no = it.number ?: 0,
                    arab = it.arab ?: "",
                    translator = it.id ?: "",
                    name = it.name
                )
            )
        }

        return listHadith
    }
}