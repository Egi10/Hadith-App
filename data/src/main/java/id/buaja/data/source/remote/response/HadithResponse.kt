package id.buaja.data.source.remote.response

import com.squareup.moshi.Json

data class HadithResponse(

	@Json(name="number")
	val number: Int? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="arab")
	val arab: String? = null,

    val name: String
)
