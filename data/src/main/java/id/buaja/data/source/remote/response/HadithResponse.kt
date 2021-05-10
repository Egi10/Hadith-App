package id.buaja.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class HadithResponse(

    @field:SerializedName("number")
    val number: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("arab")
    val arab: String? = null,

    val name: String? = ""
)
